package com.ssm.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EntitlementExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EntitlementExample() {
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

        public Criteria andEtmUserUuidIsNull() {
            addCriterion("etm_user_uuid is null");
            return (Criteria) this;
        }

        public Criteria andEtmUserUuidIsNotNull() {
            addCriterion("etm_user_uuid is not null");
            return (Criteria) this;
        }

        public Criteria andEtmUserUuidEqualTo(String value) {
            addCriterion("etm_user_uuid =", value, "etmUserUuid");
            return (Criteria) this;
        }

        public Criteria andEtmUserUuidNotEqualTo(String value) {
            addCriterion("etm_user_uuid <>", value, "etmUserUuid");
            return (Criteria) this;
        }

        public Criteria andEtmUserUuidGreaterThan(String value) {
            addCriterion("etm_user_uuid >", value, "etmUserUuid");
            return (Criteria) this;
        }

        public Criteria andEtmUserUuidGreaterThanOrEqualTo(String value) {
            addCriterion("etm_user_uuid >=", value, "etmUserUuid");
            return (Criteria) this;
        }

        public Criteria andEtmUserUuidLessThan(String value) {
            addCriterion("etm_user_uuid <", value, "etmUserUuid");
            return (Criteria) this;
        }

        public Criteria andEtmUserUuidLessThanOrEqualTo(String value) {
            addCriterion("etm_user_uuid <=", value, "etmUserUuid");
            return (Criteria) this;
        }

        public Criteria andEtmUserUuidLike(String value) {
            addCriterion("etm_user_uuid like", value, "etmUserUuid");
            return (Criteria) this;
        }

        public Criteria andEtmUserUuidNotLike(String value) {
            addCriterion("etm_user_uuid not like", value, "etmUserUuid");
            return (Criteria) this;
        }

        public Criteria andEtmUserUuidIn(List<String> values) {
            addCriterion("etm_user_uuid in", values, "etmUserUuid");
            return (Criteria) this;
        }

        public Criteria andEtmUserUuidNotIn(List<String> values) {
            addCriterion("etm_user_uuid not in", values, "etmUserUuid");
            return (Criteria) this;
        }

        public Criteria andEtmUserUuidBetween(String value1, String value2) {
            addCriterion("etm_user_uuid between", value1, value2, "etmUserUuid");
            return (Criteria) this;
        }

        public Criteria andEtmUserUuidNotBetween(String value1, String value2) {
            addCriterion("etm_user_uuid not between", value1, value2, "etmUserUuid");
            return (Criteria) this;
        }

        public Criteria andEtmAcctUuidIsNull() {
            addCriterion("etm_acct_uuid is null");
            return (Criteria) this;
        }

        public Criteria andEtmAcctUuidIsNotNull() {
            addCriterion("etm_acct_uuid is not null");
            return (Criteria) this;
        }

        public Criteria andEtmAcctUuidEqualTo(String value) {
            addCriterion("etm_acct_uuid =", value, "etmAcctUuid");
            return (Criteria) this;
        }

        public Criteria andEtmAcctUuidNotEqualTo(String value) {
            addCriterion("etm_acct_uuid <>", value, "etmAcctUuid");
            return (Criteria) this;
        }

        public Criteria andEtmAcctUuidGreaterThan(String value) {
            addCriterion("etm_acct_uuid >", value, "etmAcctUuid");
            return (Criteria) this;
        }

        public Criteria andEtmAcctUuidGreaterThanOrEqualTo(String value) {
            addCriterion("etm_acct_uuid >=", value, "etmAcctUuid");
            return (Criteria) this;
        }

        public Criteria andEtmAcctUuidLessThan(String value) {
            addCriterion("etm_acct_uuid <", value, "etmAcctUuid");
            return (Criteria) this;
        }

        public Criteria andEtmAcctUuidLessThanOrEqualTo(String value) {
            addCriterion("etm_acct_uuid <=", value, "etmAcctUuid");
            return (Criteria) this;
        }

        public Criteria andEtmAcctUuidLike(String value) {
            addCriterion("etm_acct_uuid like", value, "etmAcctUuid");
            return (Criteria) this;
        }

        public Criteria andEtmAcctUuidNotLike(String value) {
            addCriterion("etm_acct_uuid not like", value, "etmAcctUuid");
            return (Criteria) this;
        }

        public Criteria andEtmAcctUuidIn(List<String> values) {
            addCriterion("etm_acct_uuid in", values, "etmAcctUuid");
            return (Criteria) this;
        }

        public Criteria andEtmAcctUuidNotIn(List<String> values) {
            addCriterion("etm_acct_uuid not in", values, "etmAcctUuid");
            return (Criteria) this;
        }

        public Criteria andEtmAcctUuidBetween(String value1, String value2) {
            addCriterion("etm_acct_uuid between", value1, value2, "etmAcctUuid");
            return (Criteria) this;
        }

        public Criteria andEtmAcctUuidNotBetween(String value1, String value2) {
            addCriterion("etm_acct_uuid not between", value1, value2, "etmAcctUuid");
            return (Criteria) this;
        }

        public Criteria andEtmStatusIsNull() {
            addCriterion("etm_status is null");
            return (Criteria) this;
        }

        public Criteria andEtmStatusIsNotNull() {
            addCriterion("etm_status is not null");
            return (Criteria) this;
        }

        public Criteria andEtmStatusEqualTo(Integer value) {
            addCriterion("etm_status =", value, "etmStatus");
            return (Criteria) this;
        }

        public Criteria andEtmStatusNotEqualTo(Integer value) {
            addCriterion("etm_status <>", value, "etmStatus");
            return (Criteria) this;
        }

        public Criteria andEtmStatusGreaterThan(Integer value) {
            addCriterion("etm_status >", value, "etmStatus");
            return (Criteria) this;
        }

        public Criteria andEtmStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("etm_status >=", value, "etmStatus");
            return (Criteria) this;
        }

        public Criteria andEtmStatusLessThan(Integer value) {
            addCriterion("etm_status <", value, "etmStatus");
            return (Criteria) this;
        }

        public Criteria andEtmStatusLessThanOrEqualTo(Integer value) {
            addCriterion("etm_status <=", value, "etmStatus");
            return (Criteria) this;
        }

        public Criteria andEtmStatusIn(List<Integer> values) {
            addCriterion("etm_status in", values, "etmStatus");
            return (Criteria) this;
        }

        public Criteria andEtmStatusNotIn(List<Integer> values) {
            addCriterion("etm_status not in", values, "etmStatus");
            return (Criteria) this;
        }

        public Criteria andEtmStatusBetween(Integer value1, Integer value2) {
            addCriterion("etm_status between", value1, value2, "etmStatus");
            return (Criteria) this;
        }

        public Criteria andEtmStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("etm_status not between", value1, value2, "etmStatus");
            return (Criteria) this;
        }

        public Criteria andEtmPolUuidIsNull() {
            addCriterion("etm_pol_uuid is null");
            return (Criteria) this;
        }

        public Criteria andEtmPolUuidIsNotNull() {
            addCriterion("etm_pol_uuid is not null");
            return (Criteria) this;
        }

        public Criteria andEtmPolUuidEqualTo(String value) {
            addCriterion("etm_pol_uuid =", value, "etmPolUuid");
            return (Criteria) this;
        }

        public Criteria andEtmPolUuidNotEqualTo(String value) {
            addCriterion("etm_pol_uuid <>", value, "etmPolUuid");
            return (Criteria) this;
        }

        public Criteria andEtmPolUuidGreaterThan(String value) {
            addCriterion("etm_pol_uuid >", value, "etmPolUuid");
            return (Criteria) this;
        }

        public Criteria andEtmPolUuidGreaterThanOrEqualTo(String value) {
            addCriterion("etm_pol_uuid >=", value, "etmPolUuid");
            return (Criteria) this;
        }

        public Criteria andEtmPolUuidLessThan(String value) {
            addCriterion("etm_pol_uuid <", value, "etmPolUuid");
            return (Criteria) this;
        }

        public Criteria andEtmPolUuidLessThanOrEqualTo(String value) {
            addCriterion("etm_pol_uuid <=", value, "etmPolUuid");
            return (Criteria) this;
        }

        public Criteria andEtmPolUuidLike(String value) {
            addCriterion("etm_pol_uuid like", value, "etmPolUuid");
            return (Criteria) this;
        }

        public Criteria andEtmPolUuidNotLike(String value) {
            addCriterion("etm_pol_uuid not like", value, "etmPolUuid");
            return (Criteria) this;
        }

        public Criteria andEtmPolUuidIn(List<String> values) {
            addCriterion("etm_pol_uuid in", values, "etmPolUuid");
            return (Criteria) this;
        }

        public Criteria andEtmPolUuidNotIn(List<String> values) {
            addCriterion("etm_pol_uuid not in", values, "etmPolUuid");
            return (Criteria) this;
        }

        public Criteria andEtmPolUuidBetween(String value1, String value2) {
            addCriterion("etm_pol_uuid between", value1, value2, "etmPolUuid");
            return (Criteria) this;
        }

        public Criteria andEtmPolUuidNotBetween(String value1, String value2) {
            addCriterion("etm_pol_uuid not between", value1, value2, "etmPolUuid");
            return (Criteria) this;
        }

        public Criteria andEtmCreatorUuidIsNull() {
            addCriterion("etm_creator_uuid is null");
            return (Criteria) this;
        }

        public Criteria andEtmCreatorUuidIsNotNull() {
            addCriterion("etm_creator_uuid is not null");
            return (Criteria) this;
        }

        public Criteria andEtmCreatorUuidEqualTo(String value) {
            addCriterion("etm_creator_uuid =", value, "etmCreatorUuid");
            return (Criteria) this;
        }

        public Criteria andEtmCreatorUuidNotEqualTo(String value) {
            addCriterion("etm_creator_uuid <>", value, "etmCreatorUuid");
            return (Criteria) this;
        }

        public Criteria andEtmCreatorUuidGreaterThan(String value) {
            addCriterion("etm_creator_uuid >", value, "etmCreatorUuid");
            return (Criteria) this;
        }

        public Criteria andEtmCreatorUuidGreaterThanOrEqualTo(String value) {
            addCriterion("etm_creator_uuid >=", value, "etmCreatorUuid");
            return (Criteria) this;
        }

        public Criteria andEtmCreatorUuidLessThan(String value) {
            addCriterion("etm_creator_uuid <", value, "etmCreatorUuid");
            return (Criteria) this;
        }

        public Criteria andEtmCreatorUuidLessThanOrEqualTo(String value) {
            addCriterion("etm_creator_uuid <=", value, "etmCreatorUuid");
            return (Criteria) this;
        }

        public Criteria andEtmCreatorUuidLike(String value) {
            addCriterion("etm_creator_uuid like", value, "etmCreatorUuid");
            return (Criteria) this;
        }

        public Criteria andEtmCreatorUuidNotLike(String value) {
            addCriterion("etm_creator_uuid not like", value, "etmCreatorUuid");
            return (Criteria) this;
        }

        public Criteria andEtmCreatorUuidIn(List<String> values) {
            addCriterion("etm_creator_uuid in", values, "etmCreatorUuid");
            return (Criteria) this;
        }

        public Criteria andEtmCreatorUuidNotIn(List<String> values) {
            addCriterion("etm_creator_uuid not in", values, "etmCreatorUuid");
            return (Criteria) this;
        }

        public Criteria andEtmCreatorUuidBetween(String value1, String value2) {
            addCriterion("etm_creator_uuid between", value1, value2, "etmCreatorUuid");
            return (Criteria) this;
        }

        public Criteria andEtmCreatorUuidNotBetween(String value1, String value2) {
            addCriterion("etm_creator_uuid not between", value1, value2, "etmCreatorUuid");
            return (Criteria) this;
        }

        public Criteria andEtmCreateTimeIsNull() {
            addCriterion("etm_create_time is null");
            return (Criteria) this;
        }

        public Criteria andEtmCreateTimeIsNotNull() {
            addCriterion("etm_create_time is not null");
            return (Criteria) this;
        }

        public Criteria andEtmCreateTimeEqualTo(Date value) {
            addCriterion("etm_create_time =", value, "etmCreateTime");
            return (Criteria) this;
        }

        public Criteria andEtmCreateTimeNotEqualTo(Date value) {
            addCriterion("etm_create_time <>", value, "etmCreateTime");
            return (Criteria) this;
        }

        public Criteria andEtmCreateTimeGreaterThan(Date value) {
            addCriterion("etm_create_time >", value, "etmCreateTime");
            return (Criteria) this;
        }

        public Criteria andEtmCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("etm_create_time >=", value, "etmCreateTime");
            return (Criteria) this;
        }

        public Criteria andEtmCreateTimeLessThan(Date value) {
            addCriterion("etm_create_time <", value, "etmCreateTime");
            return (Criteria) this;
        }

        public Criteria andEtmCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("etm_create_time <=", value, "etmCreateTime");
            return (Criteria) this;
        }

        public Criteria andEtmCreateTimeIn(List<Date> values) {
            addCriterion("etm_create_time in", values, "etmCreateTime");
            return (Criteria) this;
        }

        public Criteria andEtmCreateTimeNotIn(List<Date> values) {
            addCriterion("etm_create_time not in", values, "etmCreateTime");
            return (Criteria) this;
        }

        public Criteria andEtmCreateTimeBetween(Date value1, Date value2) {
            addCriterion("etm_create_time between", value1, value2, "etmCreateTime");
            return (Criteria) this;
        }

        public Criteria andEtmCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("etm_create_time not between", value1, value2, "etmCreateTime");
            return (Criteria) this;
        }

        public Criteria andEtmModifierUuidIsNull() {
            addCriterion("etm_modifier_uuid is null");
            return (Criteria) this;
        }

        public Criteria andEtmModifierUuidIsNotNull() {
            addCriterion("etm_modifier_uuid is not null");
            return (Criteria) this;
        }

        public Criteria andEtmModifierUuidEqualTo(String value) {
            addCriterion("etm_modifier_uuid =", value, "etmModifierUuid");
            return (Criteria) this;
        }

        public Criteria andEtmModifierUuidNotEqualTo(String value) {
            addCriterion("etm_modifier_uuid <>", value, "etmModifierUuid");
            return (Criteria) this;
        }

        public Criteria andEtmModifierUuidGreaterThan(String value) {
            addCriterion("etm_modifier_uuid >", value, "etmModifierUuid");
            return (Criteria) this;
        }

        public Criteria andEtmModifierUuidGreaterThanOrEqualTo(String value) {
            addCriterion("etm_modifier_uuid >=", value, "etmModifierUuid");
            return (Criteria) this;
        }

        public Criteria andEtmModifierUuidLessThan(String value) {
            addCriterion("etm_modifier_uuid <", value, "etmModifierUuid");
            return (Criteria) this;
        }

        public Criteria andEtmModifierUuidLessThanOrEqualTo(String value) {
            addCriterion("etm_modifier_uuid <=", value, "etmModifierUuid");
            return (Criteria) this;
        }

        public Criteria andEtmModifierUuidLike(String value) {
            addCriterion("etm_modifier_uuid like", value, "etmModifierUuid");
            return (Criteria) this;
        }

        public Criteria andEtmModifierUuidNotLike(String value) {
            addCriterion("etm_modifier_uuid not like", value, "etmModifierUuid");
            return (Criteria) this;
        }

        public Criteria andEtmModifierUuidIn(List<String> values) {
            addCriterion("etm_modifier_uuid in", values, "etmModifierUuid");
            return (Criteria) this;
        }

        public Criteria andEtmModifierUuidNotIn(List<String> values) {
            addCriterion("etm_modifier_uuid not in", values, "etmModifierUuid");
            return (Criteria) this;
        }

        public Criteria andEtmModifierUuidBetween(String value1, String value2) {
            addCriterion("etm_modifier_uuid between", value1, value2, "etmModifierUuid");
            return (Criteria) this;
        }

        public Criteria andEtmModifierUuidNotBetween(String value1, String value2) {
            addCriterion("etm_modifier_uuid not between", value1, value2, "etmModifierUuid");
            return (Criteria) this;
        }

        public Criteria andEtmModifiedTimeIsNull() {
            addCriterion("etm_modified_time is null");
            return (Criteria) this;
        }

        public Criteria andEtmModifiedTimeIsNotNull() {
            addCriterion("etm_modified_time is not null");
            return (Criteria) this;
        }

        public Criteria andEtmModifiedTimeEqualTo(Date value) {
            addCriterion("etm_modified_time =", value, "etmModifiedTime");
            return (Criteria) this;
        }

        public Criteria andEtmModifiedTimeNotEqualTo(Date value) {
            addCriterion("etm_modified_time <>", value, "etmModifiedTime");
            return (Criteria) this;
        }

        public Criteria andEtmModifiedTimeGreaterThan(Date value) {
            addCriterion("etm_modified_time >", value, "etmModifiedTime");
            return (Criteria) this;
        }

        public Criteria andEtmModifiedTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("etm_modified_time >=", value, "etmModifiedTime");
            return (Criteria) this;
        }

        public Criteria andEtmModifiedTimeLessThan(Date value) {
            addCriterion("etm_modified_time <", value, "etmModifiedTime");
            return (Criteria) this;
        }

        public Criteria andEtmModifiedTimeLessThanOrEqualTo(Date value) {
            addCriterion("etm_modified_time <=", value, "etmModifiedTime");
            return (Criteria) this;
        }

        public Criteria andEtmModifiedTimeIn(List<Date> values) {
            addCriterion("etm_modified_time in", values, "etmModifiedTime");
            return (Criteria) this;
        }

        public Criteria andEtmModifiedTimeNotIn(List<Date> values) {
            addCriterion("etm_modified_time not in", values, "etmModifiedTime");
            return (Criteria) this;
        }

        public Criteria andEtmModifiedTimeBetween(Date value1, Date value2) {
            addCriterion("etm_modified_time between", value1, value2, "etmModifiedTime");
            return (Criteria) this;
        }

        public Criteria andEtmModifiedTimeNotBetween(Date value1, Date value2) {
            addCriterion("etm_modified_time not between", value1, value2, "etmModifiedTime");
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