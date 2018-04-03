package com.ssm.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OuExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OuExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andOuUuidIsNull() {
            addCriterion("ou_uuid is null");
            return (Criteria) this;
        }

        public Criteria andOuUuidIsNotNull() {
            addCriterion("ou_uuid is not null");
            return (Criteria) this;
        }

        public Criteria andOuUuidEqualTo(String value) {
            addCriterion("ou_uuid =", value, "ouUuid");
            return (Criteria) this;
        }

        public Criteria andOuUuidNotEqualTo(String value) {
            addCriterion("ou_uuid <>", value, "ouUuid");
            return (Criteria) this;
        }

        public Criteria andOuUuidGreaterThan(String value) {
            addCriterion("ou_uuid >", value, "ouUuid");
            return (Criteria) this;
        }

        public Criteria andOuUuidGreaterThanOrEqualTo(String value) {
            addCriterion("ou_uuid >=", value, "ouUuid");
            return (Criteria) this;
        }

        public Criteria andOuUuidLessThan(String value) {
            addCriterion("ou_uuid <", value, "ouUuid");
            return (Criteria) this;
        }

        public Criteria andOuUuidLessThanOrEqualTo(String value) {
            addCriterion("ou_uuid <=", value, "ouUuid");
            return (Criteria) this;
        }

        public Criteria andOuUuidLike(String value) {
            addCriterion("ou_uuid like", value, "ouUuid");
            return (Criteria) this;
        }

        public Criteria andOuUuidNotLike(String value) {
            addCriterion("ou_uuid not like", value, "ouUuid");
            return (Criteria) this;
        }

        public Criteria andOuUuidIn(List<String> values) {
            addCriterion("ou_uuid in", values, "ouUuid");
            return (Criteria) this;
        }

        public Criteria andOuUuidNotIn(List<String> values) {
            addCriterion("ou_uuid not in", values, "ouUuid");
            return (Criteria) this;
        }

        public Criteria andOuUuidBetween(String value1, String value2) {
            addCriterion("ou_uuid between", value1, value2, "ouUuid");
            return (Criteria) this;
        }

        public Criteria andOuUuidNotBetween(String value1, String value2) {
            addCriterion("ou_uuid not between", value1, value2, "ouUuid");
            return (Criteria) this;
        }

        public Criteria andOuResUuidIsNull() {
            addCriterion("ou_res_uuid is null");
            return (Criteria) this;
        }

        public Criteria andOuResUuidIsNotNull() {
            addCriterion("ou_res_uuid is not null");
            return (Criteria) this;
        }

        public Criteria andOuResUuidEqualTo(String value) {
            addCriterion("ou_res_uuid =", value, "ouResUuid");
            return (Criteria) this;
        }

        public Criteria andOuResUuidNotEqualTo(String value) {
            addCriterion("ou_res_uuid <>", value, "ouResUuid");
            return (Criteria) this;
        }

        public Criteria andOuResUuidGreaterThan(String value) {
            addCriterion("ou_res_uuid >", value, "ouResUuid");
            return (Criteria) this;
        }

        public Criteria andOuResUuidGreaterThanOrEqualTo(String value) {
            addCriterion("ou_res_uuid >=", value, "ouResUuid");
            return (Criteria) this;
        }

        public Criteria andOuResUuidLessThan(String value) {
            addCriterion("ou_res_uuid <", value, "ouResUuid");
            return (Criteria) this;
        }

        public Criteria andOuResUuidLessThanOrEqualTo(String value) {
            addCriterion("ou_res_uuid <=", value, "ouResUuid");
            return (Criteria) this;
        }

        public Criteria andOuResUuidLike(String value) {
            addCriterion("ou_res_uuid like", value, "ouResUuid");
            return (Criteria) this;
        }

        public Criteria andOuResUuidNotLike(String value) {
            addCriterion("ou_res_uuid not like", value, "ouResUuid");
            return (Criteria) this;
        }

        public Criteria andOuResUuidIn(List<String> values) {
            addCriterion("ou_res_uuid in", values, "ouResUuid");
            return (Criteria) this;
        }

        public Criteria andOuResUuidNotIn(List<String> values) {
            addCriterion("ou_res_uuid not in", values, "ouResUuid");
            return (Criteria) this;
        }

        public Criteria andOuResUuidBetween(String value1, String value2) {
            addCriterion("ou_res_uuid between", value1, value2, "ouResUuid");
            return (Criteria) this;
        }

        public Criteria andOuResUuidNotBetween(String value1, String value2) {
            addCriterion("ou_res_uuid not between", value1, value2, "ouResUuid");
            return (Criteria) this;
        }

        public Criteria andOuTypeIsNull() {
            addCriterion("ou_type is null");
            return (Criteria) this;
        }

        public Criteria andOuTypeIsNotNull() {
            addCriterion("ou_type is not null");
            return (Criteria) this;
        }

        public Criteria andOuTypeEqualTo(Integer value) {
            addCriterion("ou_type =", value, "ouType");
            return (Criteria) this;
        }

        public Criteria andOuTypeNotEqualTo(Integer value) {
            addCriterion("ou_type <>", value, "ouType");
            return (Criteria) this;
        }

        public Criteria andOuTypeGreaterThan(Integer value) {
            addCriterion("ou_type >", value, "ouType");
            return (Criteria) this;
        }

        public Criteria andOuTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("ou_type >=", value, "ouType");
            return (Criteria) this;
        }

        public Criteria andOuTypeLessThan(Integer value) {
            addCriterion("ou_type <", value, "ouType");
            return (Criteria) this;
        }

        public Criteria andOuTypeLessThanOrEqualTo(Integer value) {
            addCriterion("ou_type <=", value, "ouType");
            return (Criteria) this;
        }

        public Criteria andOuTypeIn(List<Integer> values) {
            addCriterion("ou_type in", values, "ouType");
            return (Criteria) this;
        }

        public Criteria andOuTypeNotIn(List<Integer> values) {
            addCriterion("ou_type not in", values, "ouType");
            return (Criteria) this;
        }

        public Criteria andOuTypeBetween(Integer value1, Integer value2) {
            addCriterion("ou_type between", value1, value2, "ouType");
            return (Criteria) this;
        }

        public Criteria andOuTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("ou_type not between", value1, value2, "ouType");
            return (Criteria) this;
        }

        public Criteria andOuIdIsNull() {
            addCriterion("ou_id is null");
            return (Criteria) this;
        }

        public Criteria andOuIdIsNotNull() {
            addCriterion("ou_id is not null");
            return (Criteria) this;
        }

        public Criteria andOuIdEqualTo(String value) {
            addCriterion("ou_id =", value, "ouId");
            return (Criteria) this;
        }

        public Criteria andOuIdNotEqualTo(String value) {
            addCriterion("ou_id <>", value, "ouId");
            return (Criteria) this;
        }

        public Criteria andOuIdGreaterThan(String value) {
            addCriterion("ou_id >", value, "ouId");
            return (Criteria) this;
        }

        public Criteria andOuIdGreaterThanOrEqualTo(String value) {
            addCriterion("ou_id >=", value, "ouId");
            return (Criteria) this;
        }

        public Criteria andOuIdLessThan(String value) {
            addCriterion("ou_id <", value, "ouId");
            return (Criteria) this;
        }

        public Criteria andOuIdLessThanOrEqualTo(String value) {
            addCriterion("ou_id <=", value, "ouId");
            return (Criteria) this;
        }

        public Criteria andOuIdLike(String value) {
            addCriterion("ou_id like", value, "ouId");
            return (Criteria) this;
        }

        public Criteria andOuIdNotLike(String value) {
            addCriterion("ou_id not like", value, "ouId");
            return (Criteria) this;
        }

        public Criteria andOuIdIn(List<String> values) {
            addCriterion("ou_id in", values, "ouId");
            return (Criteria) this;
        }

        public Criteria andOuIdNotIn(List<String> values) {
            addCriterion("ou_id not in", values, "ouId");
            return (Criteria) this;
        }

        public Criteria andOuIdBetween(String value1, String value2) {
            addCriterion("ou_id between", value1, value2, "ouId");
            return (Criteria) this;
        }

        public Criteria andOuIdNotBetween(String value1, String value2) {
            addCriterion("ou_id not between", value1, value2, "ouId");
            return (Criteria) this;
        }

        public Criteria andOuNameIsNull() {
            addCriterion("ou_name is null");
            return (Criteria) this;
        }

        public Criteria andOuNameIsNotNull() {
            addCriterion("ou_name is not null");
            return (Criteria) this;
        }

        public Criteria andOuNameEqualTo(String value) {
            addCriterion("ou_name =", value, "ouName");
            return (Criteria) this;
        }

        public Criteria andOuNameNotEqualTo(String value) {
            addCriterion("ou_name <>", value, "ouName");
            return (Criteria) this;
        }

        public Criteria andOuNameGreaterThan(String value) {
            addCriterion("ou_name >", value, "ouName");
            return (Criteria) this;
        }

        public Criteria andOuNameGreaterThanOrEqualTo(String value) {
            addCriterion("ou_name >=", value, "ouName");
            return (Criteria) this;
        }

        public Criteria andOuNameLessThan(String value) {
            addCriterion("ou_name <", value, "ouName");
            return (Criteria) this;
        }

        public Criteria andOuNameLessThanOrEqualTo(String value) {
            addCriterion("ou_name <=", value, "ouName");
            return (Criteria) this;
        }

        public Criteria andOuNameLike(String value) {
            addCriterion("ou_name like", value, "ouName");
            return (Criteria) this;
        }

        public Criteria andOuNameNotLike(String value) {
            addCriterion("ou_name not like", value, "ouName");
            return (Criteria) this;
        }

        public Criteria andOuNameIn(List<String> values) {
            addCriterion("ou_name in", values, "ouName");
            return (Criteria) this;
        }

        public Criteria andOuNameNotIn(List<String> values) {
            addCriterion("ou_name not in", values, "ouName");
            return (Criteria) this;
        }

        public Criteria andOuNameBetween(String value1, String value2) {
            addCriterion("ou_name between", value1, value2, "ouName");
            return (Criteria) this;
        }

        public Criteria andOuNameNotBetween(String value1, String value2) {
            addCriterion("ou_name not between", value1, value2, "ouName");
            return (Criteria) this;
        }

        public Criteria andOuName2IsNull() {
            addCriterion("ou_name2 is null");
            return (Criteria) this;
        }

        public Criteria andOuName2IsNotNull() {
            addCriterion("ou_name2 is not null");
            return (Criteria) this;
        }

        public Criteria andOuName2EqualTo(String value) {
            addCriterion("ou_name2 =", value, "ouName2");
            return (Criteria) this;
        }

        public Criteria andOuName2NotEqualTo(String value) {
            addCriterion("ou_name2 <>", value, "ouName2");
            return (Criteria) this;
        }

        public Criteria andOuName2GreaterThan(String value) {
            addCriterion("ou_name2 >", value, "ouName2");
            return (Criteria) this;
        }

        public Criteria andOuName2GreaterThanOrEqualTo(String value) {
            addCriterion("ou_name2 >=", value, "ouName2");
            return (Criteria) this;
        }

        public Criteria andOuName2LessThan(String value) {
            addCriterion("ou_name2 <", value, "ouName2");
            return (Criteria) this;
        }

        public Criteria andOuName2LessThanOrEqualTo(String value) {
            addCriterion("ou_name2 <=", value, "ouName2");
            return (Criteria) this;
        }

        public Criteria andOuName2Like(String value) {
            addCriterion("ou_name2 like", value, "ouName2");
            return (Criteria) this;
        }

        public Criteria andOuName2NotLike(String value) {
            addCriterion("ou_name2 not like", value, "ouName2");
            return (Criteria) this;
        }

        public Criteria andOuName2In(List<String> values) {
            addCriterion("ou_name2 in", values, "ouName2");
            return (Criteria) this;
        }

        public Criteria andOuName2NotIn(List<String> values) {
            addCriterion("ou_name2 not in", values, "ouName2");
            return (Criteria) this;
        }

        public Criteria andOuName2Between(String value1, String value2) {
            addCriterion("ou_name2 between", value1, value2, "ouName2");
            return (Criteria) this;
        }

        public Criteria andOuName2NotBetween(String value1, String value2) {
            addCriterion("ou_name2 not between", value1, value2, "ouName2");
            return (Criteria) this;
        }

        public Criteria andOuDescIsNull() {
            addCriterion("ou_desc is null");
            return (Criteria) this;
        }

        public Criteria andOuDescIsNotNull() {
            addCriterion("ou_desc is not null");
            return (Criteria) this;
        }

        public Criteria andOuDescEqualTo(String value) {
            addCriterion("ou_desc =", value, "ouDesc");
            return (Criteria) this;
        }

        public Criteria andOuDescNotEqualTo(String value) {
            addCriterion("ou_desc <>", value, "ouDesc");
            return (Criteria) this;
        }

        public Criteria andOuDescGreaterThan(String value) {
            addCriterion("ou_desc >", value, "ouDesc");
            return (Criteria) this;
        }

        public Criteria andOuDescGreaterThanOrEqualTo(String value) {
            addCriterion("ou_desc >=", value, "ouDesc");
            return (Criteria) this;
        }

        public Criteria andOuDescLessThan(String value) {
            addCriterion("ou_desc <", value, "ouDesc");
            return (Criteria) this;
        }

        public Criteria andOuDescLessThanOrEqualTo(String value) {
            addCriterion("ou_desc <=", value, "ouDesc");
            return (Criteria) this;
        }

        public Criteria andOuDescLike(String value) {
            addCriterion("ou_desc like", value, "ouDesc");
            return (Criteria) this;
        }

        public Criteria andOuDescNotLike(String value) {
            addCriterion("ou_desc not like", value, "ouDesc");
            return (Criteria) this;
        }

        public Criteria andOuDescIn(List<String> values) {
            addCriterion("ou_desc in", values, "ouDesc");
            return (Criteria) this;
        }

        public Criteria andOuDescNotIn(List<String> values) {
            addCriterion("ou_desc not in", values, "ouDesc");
            return (Criteria) this;
        }

        public Criteria andOuDescBetween(String value1, String value2) {
            addCriterion("ou_desc between", value1, value2, "ouDesc");
            return (Criteria) this;
        }

        public Criteria andOuDescNotBetween(String value1, String value2) {
            addCriterion("ou_desc not between", value1, value2, "ouDesc");
            return (Criteria) this;
        }

        public Criteria andOuManagerUuidIsNull() {
            addCriterion("ou_manager_uuid is null");
            return (Criteria) this;
        }

        public Criteria andOuManagerUuidIsNotNull() {
            addCriterion("ou_manager_uuid is not null");
            return (Criteria) this;
        }

        public Criteria andOuManagerUuidEqualTo(String value) {
            addCriterion("ou_manager_uuid =", value, "ouManagerUuid");
            return (Criteria) this;
        }

        public Criteria andOuManagerUuidNotEqualTo(String value) {
            addCriterion("ou_manager_uuid <>", value, "ouManagerUuid");
            return (Criteria) this;
        }

        public Criteria andOuManagerUuidGreaterThan(String value) {
            addCriterion("ou_manager_uuid >", value, "ouManagerUuid");
            return (Criteria) this;
        }

        public Criteria andOuManagerUuidGreaterThanOrEqualTo(String value) {
            addCriterion("ou_manager_uuid >=", value, "ouManagerUuid");
            return (Criteria) this;
        }

        public Criteria andOuManagerUuidLessThan(String value) {
            addCriterion("ou_manager_uuid <", value, "ouManagerUuid");
            return (Criteria) this;
        }

        public Criteria andOuManagerUuidLessThanOrEqualTo(String value) {
            addCriterion("ou_manager_uuid <=", value, "ouManagerUuid");
            return (Criteria) this;
        }

        public Criteria andOuManagerUuidLike(String value) {
            addCriterion("ou_manager_uuid like", value, "ouManagerUuid");
            return (Criteria) this;
        }

        public Criteria andOuManagerUuidNotLike(String value) {
            addCriterion("ou_manager_uuid not like", value, "ouManagerUuid");
            return (Criteria) this;
        }

        public Criteria andOuManagerUuidIn(List<String> values) {
            addCriterion("ou_manager_uuid in", values, "ouManagerUuid");
            return (Criteria) this;
        }

        public Criteria andOuManagerUuidNotIn(List<String> values) {
            addCriterion("ou_manager_uuid not in", values, "ouManagerUuid");
            return (Criteria) this;
        }

        public Criteria andOuManagerUuidBetween(String value1, String value2) {
            addCriterion("ou_manager_uuid between", value1, value2, "ouManagerUuid");
            return (Criteria) this;
        }

        public Criteria andOuManagerUuidNotBetween(String value1, String value2) {
            addCriterion("ou_manager_uuid not between", value1, value2, "ouManagerUuid");
            return (Criteria) this;
        }

        public Criteria andOuParentUuidIsNull() {
            addCriterion("ou_parent_uuid is null");
            return (Criteria) this;
        }

        public Criteria andOuParentUuidIsNotNull() {
            addCriterion("ou_parent_uuid is not null");
            return (Criteria) this;
        }

        public Criteria andOuParentUuidEqualTo(String value) {
            addCriterion("ou_parent_uuid =", value, "ouParentUuid");
            return (Criteria) this;
        }

        public Criteria andOuParentUuidNotEqualTo(String value) {
            addCriterion("ou_parent_uuid <>", value, "ouParentUuid");
            return (Criteria) this;
        }

        public Criteria andOuParentUuidGreaterThan(String value) {
            addCriterion("ou_parent_uuid >", value, "ouParentUuid");
            return (Criteria) this;
        }

        public Criteria andOuParentUuidGreaterThanOrEqualTo(String value) {
            addCriterion("ou_parent_uuid >=", value, "ouParentUuid");
            return (Criteria) this;
        }

        public Criteria andOuParentUuidLessThan(String value) {
            addCriterion("ou_parent_uuid <", value, "ouParentUuid");
            return (Criteria) this;
        }

        public Criteria andOuParentUuidLessThanOrEqualTo(String value) {
            addCriterion("ou_parent_uuid <=", value, "ouParentUuid");
            return (Criteria) this;
        }

        public Criteria andOuParentUuidLike(String value) {
            addCriterion("ou_parent_uuid like", value, "ouParentUuid");
            return (Criteria) this;
        }

        public Criteria andOuParentUuidNotLike(String value) {
            addCriterion("ou_parent_uuid not like", value, "ouParentUuid");
            return (Criteria) this;
        }

        public Criteria andOuParentUuidIn(List<String> values) {
            addCriterion("ou_parent_uuid in", values, "ouParentUuid");
            return (Criteria) this;
        }

        public Criteria andOuParentUuidNotIn(List<String> values) {
            addCriterion("ou_parent_uuid not in", values, "ouParentUuid");
            return (Criteria) this;
        }

        public Criteria andOuParentUuidBetween(String value1, String value2) {
            addCriterion("ou_parent_uuid between", value1, value2, "ouParentUuid");
            return (Criteria) this;
        }

        public Criteria andOuParentUuidNotBetween(String value1, String value2) {
            addCriterion("ou_parent_uuid not between", value1, value2, "ouParentUuid");
            return (Criteria) this;
        }

        public Criteria andOuTgtUuidIsNull() {
            addCriterion("ou_tgt_uuid is null");
            return (Criteria) this;
        }

        public Criteria andOuTgtUuidIsNotNull() {
            addCriterion("ou_tgt_uuid is not null");
            return (Criteria) this;
        }

        public Criteria andOuTgtUuidEqualTo(String value) {
            addCriterion("ou_tgt_uuid =", value, "ouTgtUuid");
            return (Criteria) this;
        }

        public Criteria andOuTgtUuidNotEqualTo(String value) {
            addCriterion("ou_tgt_uuid <>", value, "ouTgtUuid");
            return (Criteria) this;
        }

        public Criteria andOuTgtUuidGreaterThan(String value) {
            addCriterion("ou_tgt_uuid >", value, "ouTgtUuid");
            return (Criteria) this;
        }

        public Criteria andOuTgtUuidGreaterThanOrEqualTo(String value) {
            addCriterion("ou_tgt_uuid >=", value, "ouTgtUuid");
            return (Criteria) this;
        }

        public Criteria andOuTgtUuidLessThan(String value) {
            addCriterion("ou_tgt_uuid <", value, "ouTgtUuid");
            return (Criteria) this;
        }

        public Criteria andOuTgtUuidLessThanOrEqualTo(String value) {
            addCriterion("ou_tgt_uuid <=", value, "ouTgtUuid");
            return (Criteria) this;
        }

        public Criteria andOuTgtUuidLike(String value) {
            addCriterion("ou_tgt_uuid like", value, "ouTgtUuid");
            return (Criteria) this;
        }

        public Criteria andOuTgtUuidNotLike(String value) {
            addCriterion("ou_tgt_uuid not like", value, "ouTgtUuid");
            return (Criteria) this;
        }

        public Criteria andOuTgtUuidIn(List<String> values) {
            addCriterion("ou_tgt_uuid in", values, "ouTgtUuid");
            return (Criteria) this;
        }

        public Criteria andOuTgtUuidNotIn(List<String> values) {
            addCriterion("ou_tgt_uuid not in", values, "ouTgtUuid");
            return (Criteria) this;
        }

        public Criteria andOuTgtUuidBetween(String value1, String value2) {
            addCriterion("ou_tgt_uuid between", value1, value2, "ouTgtUuid");
            return (Criteria) this;
        }

        public Criteria andOuTgtUuidNotBetween(String value1, String value2) {
            addCriterion("ou_tgt_uuid not between", value1, value2, "ouTgtUuid");
            return (Criteria) this;
        }

        public Criteria andOuLastReconTimeIsNull() {
            addCriterion("ou_last_recon_time is null");
            return (Criteria) this;
        }

        public Criteria andOuLastReconTimeIsNotNull() {
            addCriterion("ou_last_recon_time is not null");
            return (Criteria) this;
        }

        public Criteria andOuLastReconTimeEqualTo(Date value) {
            addCriterion("ou_last_recon_time =", value, "ouLastReconTime");
            return (Criteria) this;
        }

        public Criteria andOuLastReconTimeNotEqualTo(Date value) {
            addCriterion("ou_last_recon_time <>", value, "ouLastReconTime");
            return (Criteria) this;
        }

        public Criteria andOuLastReconTimeGreaterThan(Date value) {
            addCriterion("ou_last_recon_time >", value, "ouLastReconTime");
            return (Criteria) this;
        }

        public Criteria andOuLastReconTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("ou_last_recon_time >=", value, "ouLastReconTime");
            return (Criteria) this;
        }

        public Criteria andOuLastReconTimeLessThan(Date value) {
            addCriterion("ou_last_recon_time <", value, "ouLastReconTime");
            return (Criteria) this;
        }

        public Criteria andOuLastReconTimeLessThanOrEqualTo(Date value) {
            addCriterion("ou_last_recon_time <=", value, "ouLastReconTime");
            return (Criteria) this;
        }

        public Criteria andOuLastReconTimeIn(List<Date> values) {
            addCriterion("ou_last_recon_time in", values, "ouLastReconTime");
            return (Criteria) this;
        }

        public Criteria andOuLastReconTimeNotIn(List<Date> values) {
            addCriterion("ou_last_recon_time not in", values, "ouLastReconTime");
            return (Criteria) this;
        }

        public Criteria andOuLastReconTimeBetween(Date value1, Date value2) {
            addCriterion("ou_last_recon_time between", value1, value2, "ouLastReconTime");
            return (Criteria) this;
        }

        public Criteria andOuLastReconTimeNotBetween(Date value1, Date value2) {
            addCriterion("ou_last_recon_time not between", value1, value2, "ouLastReconTime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}