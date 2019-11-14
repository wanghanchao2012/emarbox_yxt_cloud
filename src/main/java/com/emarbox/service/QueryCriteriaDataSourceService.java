package com.emarbox.service;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.ListUtils;
import org.apache.commons.lang3.EnumUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emarbox.dao.DevelopersDao;
import com.emarbox.domain.po.Developers;
import com.emarbox.domain.po.EmarboxUser;
import com.emarbox.domain.vo.OptionItemVo;
import com.emarbox.enums.AuditsStateEnum;
import com.emarbox.enums.IPairsEnum;
import com.emarbox.enums.condition.ConditSubdivisionDevEnum;
import com.emarbox.enums.condition.ConditionSourceTypeEnum;
import com.emarbox.mapper.MapperProvider;
import com.emarbox.util.OptionUtils;

@Service
@SuppressWarnings({ "rawtypes", "unchecked" })
public class QueryCriteriaDataSourceService {
	@Autowired
	MapperProvider mapperProvider;
	@Autowired
	DevelopersDao developersDao;

	public Map<String, List<OptionItemVo>> getCriteriaDataSourceMap(ConditionSourceTypeEnum sourceType) {
		List<? extends IPairsEnum<?, ?, ?>> sourceTypeList = sourceType.getSourceTypeList();
		Map<String, List<OptionItemVo>> result = new HashMap<String, List<OptionItemVo>>();
		for (IPairsEnum<?, ?, ?> iPairs : sourceTypeList) {
			List<OptionItemVo> optionList = conditionSourcePreparation(iPairs).apply(iPairs);
			result.put(iPairs.get().name(), optionList);
		}
		return result;
	}

	public Function<IPairsEnum, List<OptionItemVo>> conditionSourcePreparation(IPairsEnum sourceType) {
		Function<IPairsEnum, List<OptionItemVo>> conditionSource = null;
		Enum<ConditSubdivisionDevEnum> sourceEnum = sourceType.get();
		if (sourceEnum.equals(ConditSubdivisionDevEnum.account)) {
			conditionSource = buildAccountOptions();
		}
		if (sourceEnum.equals(ConditSubdivisionDevEnum.audits_state)) {
			conditionSource = buildAuditStateOptions();
		}
		if (sourceEnum.equals(ConditSubdivisionDevEnum.business_people)) {
			conditionSource = buildBusinessPeopleOptions();
		}
		if (sourceEnum.equals(ConditSubdivisionDevEnum.develop_combine)) {
			conditionSource = buildDevelopPtOptions();
		}

		return Optional.ofNullable(conditionSource).orElse(t->Collections.emptyList());

	}

	private Function<IPairsEnum, List<OptionItemVo>> buildAuditStateOptions() {
		List<OptionItemVo> options = EnumUtils.getEnumList(AuditsStateEnum.class).stream()
				.map(enums -> OptionItemVo.builder().text(enums.getDesc()).value(enums.name()).build())
				.collect(Collectors.toList());
		return t -> OptionUtils.defPreAppend(options);
	}

	private Function<IPairsEnum, List<OptionItemVo>> buildBusinessPeopleOptions() {
		List<EmarboxUser> businessPeopleList = mapperProvider.getAuth().getEmarboxUserMapper().getBusinessPeopleList();
		if (CollectionUtils.isNotEmpty(businessPeopleList)) {
			List<OptionItemVo> options = businessPeopleList.stream().map(
					mapper -> OptionItemVo.builder().text(mapper.getDisplayName()).value(mapper.getUserId()).build())
					.collect(Collectors.toList());
			return t -> OptionUtils.defPreAppend(options);
		}
		return t -> Collections.emptyList();
	}

	private Function<IPairsEnum, List<OptionItemVo>> buildAccountOptions() {
		List<Developers> developList = developersDao.getDevelopersOfNormal();
		if (CollectionUtils.isNotEmpty(developList)) {
			List<OptionItemVo> options = developList.stream()
					.map(mapper -> OptionItemVo.builder().text(mapper.getAccountNo()).value(mapper.getId()).build())
					.collect(Collectors.toList());
			return t -> OptionUtils.defPreAppend(options);
		}
		return t -> Collections.emptyList();
	}

	private Function<IPairsEnum, List<OptionItemVo>> buildDevelopPtOptions() {
		List<Developers> developList = developersDao.getDevelopersOfNormal();
		if (CollectionUtils.isNotEmpty(developList)) {
			List<OptionItemVo> options = developList.stream()
					.map(mapper -> OptionItemVo.builder().text(mapper.getDevelopName()).value(mapper.getId()).build())
					.collect(Collectors.toList());
			return t -> OptionUtils.defPreAppend(options);
		}
		return t -> Collections.emptyList();
	}
}
