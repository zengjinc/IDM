package com.ssm.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PrivilegeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PrivilegeExample() {
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

        public Criteria andPvgUuidIsNull() {
            addCriterion("pvg_uuid is null");
            return (Criteria) this;
        }

        public Criteria andPvgUuidIsNotNull() {
            addCriterion("pvg_uuid is not null");
            return (Criteria) this;
        }

        public Criteria andPvgUuidEqualTo(String value) {
            addCriterion("pvg_uuid =", value, "pvgUuid");
            return (Criteria) this;
        }

        public Criteria andPvgUuidNotEqualTo(String value) {
            addCriterion("pvg_uuid <>", value, "pvgUuid");
            return (Criteria) this;
        }

        public Criteria andPvgUuidGreaterThan(String value) {
            addCriterion("pvg_uuid >", value, "pvgUuid");
            return (Criteria) this;
        }

        public Criteria andPvgUuidGreaterThanOrEqualTo(String value) {
            addCriterion("pvg_uuid >=", value, "pvgUuid");
            return (Criteria) this;
        }

        public Criteria andPvgUuidLessThan(String value) {
            addCriterion("pvg_uuid <", value, "pvgUuid");
            return (Criteria) this;
        }

        public Criteria andPvgUuidLessThanOrEqualTo(String value) {
            addCriterion("pvg_uuid <=", value, "pvgUuid");
            return (Criteria) this;
        }

        public Criteria andPvgUuidLike(String value) {
            addCriterion("pvg_uuid like", value, "pvgUuid");
            return (Criteria) this;
        }

        public Criteria andPvgUuidNotLike(String value) {
            addCriterion("pvg_uuid not like", value, "pvgUuid");
            return (Criteria) this;
        }

        public Criteria andPvgUuidIn(List<String> values) {
            addCriterion("pvg_uuid in", values, "pvgUuid");
            return (Criteria) this;
        }

        public Criteria andPvgUuidNotIn(List<String> values) {
            addCriterion("pvg_uuid not in", values, "pvgUuid");
            return (Criteria) this;
        }

        public Criteria andPvgUuidBetween(String value1, String value2) {
            addCriterion("pvg_uuid between", value1, value2, "pvgUuid");
            return (Criteria) this;
        }

        public Criteria andPvgUuidNotBetween(String value1, String value2) {
            addCriterion("pvg_uuid not between", value1, value2, "pvgUuid");
            return (Criteria) this;
        }

        public Criteria andPvgAcctUuidIsNull() {
            addCriterion("pvg_acct_uuid is null");
            return (Criteria) this;
        }

        public Criteria andPvgAcctUuidIsNotNull() {
            addCriterion("pvg_acct_uuid is not null");
            return (Criteria) this;
        }

        public Criteria andPvgAcctUuidEqualTo(String value) {
            addCriterion("pvg_acct_uuid =", value, "pvgAcctUuid");
            return (Criteria) this;
        }

        public Criteria andPvgAcctUuidNotEqualTo(String value) {
            addCriterion("pvg_acct_uuid <>", value, "pvgAcctUuid");
            return (Criteria) this;
        }

        public Criteria andPvgAcctUuidGreaterThan(String value) {
            addCriterion("pvg_acct_uuid >", value, "pvgAcctUuid");
            return (Criteria) this;
        }

        public Criteria andPvgAcctUuidGreaterThanOrEqualTo(String value) {
            addCriterion("pvg_acct_uuid >=", value, "pvgAcctUuid");
            return (Criteria) this;
        }

        public Criteria andPvgAcctUuidLessThan(String value) {
            addCriterion("pvg_acct_uuid <", value, "pvgAcctUuid");
            return (Criteria) this;
        }

        public Criteria andPvgAcctUuidLessThanOrEqualTo(String value) {
            addCriterion("pvg_acct_uuid <=", value, "pvgAcctUuid");
            return (Criteria) this;
        }

        public Criteria andPvgAcctUuidLike(String value) {
            addCriterion("pvg_acct_uuid like", value, "pvgAcctUuid");
            return (Criteria) this;
        }

        public Criteria andPvgAcctUuidNotLike(String value) {
            addCriterion("pvg_acct_uuid not like", value, "pvgAcctUuid");
            return (Criteria) this;
        }

        public Criteria andPvgAcctUuidIn(List<String> values) {
            addCriterion("pvg_acct_uuid in", values, "pvgAcctUuid");
            return (Criteria) this;
        }

        public Criteria andPvgAcctUuidNotIn(List<String> values) {
            addCriterion("pvg_acct_uuid not in", values, "pvgAcctUuid");
            return (Criteria) this;
        }

        public Criteria andPvgAcctUuidBetween(String value1, String value2) {
            addCriterion("pvg_acct_uuid between", value1, value2, "pvgAcctUuid");
            return (Criteria) this;
        }

        public Criteria andPvgAcctUuidNotBetween(String value1, String value2) {
            addCriterion("pvg_acct_uuid not between", value1, value2, "pvgAcctUuid");
            return (Criteria) this;
        }

        public Criteria andPvgItroleUuidIsNull() {
            addCriterion("pvg_itrole_uuid is null");
            return (Criteria) this;
        }

        public Criteria andPvgItroleUuidIsNotNull() {
            addCriterion("pvg_itrole_uuid is not null");
            return (Criteria) this;
        }

        public Criteria andPvgItroleUuidEqualTo(String value) {
            addCriterion("pvg_itrole_uuid =", value, "pvgItroleUuid");
            return (Criteria) this;
        }

        public Criteria andPvgItroleUuidNotEqualTo(String value) {
            addCriterion("pvg_itrole_uuid <>", value, "pvgItroleUuid");
            return (Criteria) this;
        }

        public Criteria andPvgItroleUuidGreaterThan(String value) {
            addCriterion("pvg_itrole_uuid >", value, "pvgItroleUuid");
            return (Criteria) this;
        }

        public Criteria andPvgItroleUuidGreaterThanOrEqualTo(String value) {
            addCriterion("pvg_itrole_uuid >=", value, "pvgItroleUuid");
            return (Criteria) this;
        }

        public Criteria andPvgItroleUuidLessThan(String value) {
            addCriterion("pvg_itrole_uuid <", value, "pvgItroleUuid");
            return (Criteria) this;
        }

        public Criteria andPvgItroleUuidLessThanOrEqualTo(String value) {
            addCriterion("pvg_itrole_uuid <=", value, "pvgItroleUuid");
            return (Criteria) this;
        }

        public Criteria andPvgItroleUuidLike(String value) {
            addCriterion("pvg_itrole_uuid like", value, "pvgItroleUuid");
            return (Criteria) this;
        }

        public Criteria andPvgItroleUuidNotLike(String value) {
            addCriterion("pvg_itrole_uuid not like", value, "pvgItroleUuid");
            return (Criteria) this;
        }

        public Criteria andPvgItroleUuidIn(List<String> values) {
            addCriterion("pvg_itrole_uuid in", values, "pvgItroleUuid");
            return (Criteria) this;
        }

        public Criteria andPvgItroleUuidNotIn(List<String> values) {
            addCriterion("pvg_itrole_uuid not in", values, "pvgItroleUuid");
            return (Criteria) this;
        }

        public Criteria andPvgItroleUuidBetween(String value1, String value2) {
            addCriterion("pvg_itrole_uuid between", value1, value2, "pvgItroleUuid");
            return (Criteria) this;
        }

        public Criteria andPvgItroleUuidNotBetween(String value1, String value2) {
            addCriterion("pvg_itrole_uuid not between", value1, value2, "pvgItroleUuid");
            return (Criteria) this;
        }

        public Criteria andPvgCreatorUuidIsNull() {
            addCriterion("pvg_creator_uuid is null");
            return (Criteria) this;
        }

        public Criteria andPvgCreatorUuidIsNotNull() {
            addCriterion("pvg_creator_uuid is not null");
            return (Criteria) this;
        }

        public Criteria andPvgCreatorUuidEqualTo(String value) {
            addCriterion("pvg_creator_uuid =", value, "pvgCreatorUuid");
            return (Criteria) this;
        }

        public Criteria andPvgCreatorUuidNotEqualTo(String value) {
            addCriterion("pvg_creator_uuid <>", value, "pvgCreatorUuid");
            return (Criteria) this;
        }

        public Criteria andPvgCreatorUuidGreaterThan(String value) {
            addCriterion("pvg_creator_uuid >", value, "pvgCreatorUuid");
            return (Criteria) this;
        }

        public Criteria andPvgCreatorUuidGreaterThanOrEqualTo(String value) {
            addCriterion("pvg_creator_uuid >=", value, "pvgCreatorUuid");
            return (Criteria) this;
        }

        public Criteria andPvgCreatorUuidLessThan(String value) {
            addCriterion("pvg_creator_uuid <", value, "pvgCreatorUuid");
            return (Criteria) this;
        }

        public Criteria andPvgCreatorUuidLessThanOrEqualTo(String value) {
            addCriterion("pvg_creator_uuid <=", value, "pvgCreatorUuid");
            return (Criteria) this;
        }

        public Criteria andPvgCreatorUuidLike(String value) {
            addCriterion("pvg_creator_uuid like", value, "pvgCreatorUuid");
            return (Criteria) this;
        }

        public Criteria andPvgCreatorUuidNotLike(String value) {
            addCriterion("pvg_creator_uuid not like", value, "pvgCreatorUuid");
            return (Criteria) this;
        }

        public Criteria andPvgCreatorUuidIn(List<String> values) {
            addCriterion("pvg_creator_uuid in", values, "pvgCreatorUuid");
            return (Criteria) this;
        }

        public Criteria andPvgCreatorUuidNotIn(List<String> values) {
            addCriterion("pvg_creator_uuid not in", values, "pvgCreatorUuid");
            return (Criteria) this;
        }

        public Criteria andPvgCreatorUuidBetween(String value1, String value2) {
            addCriterion("pvg_creator_uuid between", value1, value2, "pvgCreatorUuid");
            return (Criteria) this;
        }

        public Criteria andPvgCreatorUuidNotBetween(String value1, String value2) {
            addCriterion("pvg_creator_uuid not between", value1, value2, "pvgCreatorUuid");
            return (Criteria) this;
        }

        public Criteria andPvgCreateTimeIsNull() {
            addCriterion("pvg_create_time is null");
            return (Criteria) this;
        }

        public Criteria andPvgCreateTimeIsNotNull() {
            addCriterion("pvg_create_time is not null");
            return (Criteria) this;
        }

        public Criteria andPvgCreateTimeEqualTo(Date value) {
            addCriterion("pvg_create_time =", value, "pvgCreateTime");
            return (Criteria) this;
        }

        public Criteria andPvgCreateTimeNotEqualTo(Date value) {
            addCriterion("pvg_create_time <>", value, "pvgCreateTime");
            return (Criteria) this;
        }

        public Criteria andPvgCreateTimeGreaterThan(Date value) {
            addCriterion("pvg_create_time >", value, "pvgCreateTime");
            return (Criteria) this;
        }

        public Criteria andPvgCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("pvg_create_time >=", value, "pvgCreateTime");
            return (Criteria) this;
        }

        public Criteria andPvgCreateTimeLessThan(Date value) {
            addCriterion("pvg_create_time <", value, "pvgCreateTime");
            return (Criteria) this;
        }

        public Criteria andPvgCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("pvg_create_time <=", value, "pvgCreateTime");
            return (Criteria) this;
        }

        public Criteria andPvgCreateTimeIn(List<Date> values) {
            addCriterion("pvg_create_time in", values, "pvgCreateTime");
            return (Criteria) this;
        }

        public Criteria andPvgCreateTimeNotIn(List<Date> values) {
            addCriterion("pvg_create_time not in", values, "pvgCreateTime");
            return (Criteria) this;
        }

        public Criteria andPvgCreateTimeBetween(Date value1, Date value2) {
            addCriterion("pvg_create_time between", value1, value2, "pvgCreateTime");
            return (Criteria) this;
        }

        public Criteria andPvgCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("pvg_create_time not between", value1, value2, "pvgCreateTime");
            return (Criteria) this;
        }

        public Criteria andPvgModifierIsNull() {
            addCriterion("pvg_modifier is null");
            return (Criteria) this;
        }

        public Criteria andPvgModifierIsNotNull() {
            addCriterion("pvg_modifier is not null");
            return (Criteria) this;
        }

        public Criteria andPvgModifierEqualTo(String value) {
            addCriterion("pvg_modifier =", value, "pvgModifier");
            return (Criteria) this;
        }

        public Criteria andPvgModifierNotEqualTo(String value) {
            addCriterion("pvg_modifier <>", value, "pvgModifier");
            return (Criteria) this;
        }

        public Criteria andPvgModifierGreaterThan(String value) {
            addCriterion("pvg_modifier >", value, "pvgModifier");
            return (Criteria) this;
        }

        public Criteria andPvgModifierGreaterThanOrEqualTo(String value) {
            addCriterion("pvg_modifier >=", value, "pvgModifier");
            return (Criteria) this;
        }

        public Criteria andPvgModifierLessThan(String value) {
            addCriterion("pvg_modifier <", value, "pvgModifier");
            return (Criteria) this;
        }

        public Criteria andPvgModifierLessThanOrEqualTo(String value) {
            addCriterion("pvg_modifier <=", value, "pvgModifier");
            return (Criteria) this;
        }

        public Criteria andPvgModifierLike(String value) {
            addCriterion("pvg_modifier like", value, "pvgModifier");
            return (Criteria) this;
        }

        public Criteria andPvgModifierNotLike(String value) {
            addCriterion("pvg_modifier not like", value, "pvgModifier");
            return (Criteria) this;
        }

        public Criteria andPvgModifierIn(List<String> values) {
            addCriterion("pvg_modifier in", values, "pvgModifier");
            return (Criteria) this;
        }

        public Criteria andPvgModifierNotIn(List<String> values) {
            addCriterion("pvg_modifier not in", values, "pvgModifier");
            return (Criteria) this;
        }

        public Criteria andPvgModifierBetween(String value1, String value2) {
            addCriterion("pvg_modifier between", value1, value2, "pvgModifier");
            return (Criteria) this;
        }

        public Criteria andPvgModifierNotBetween(String value1, String value2) {
            addCriterion("pvg_modifier not between", value1, value2, "pvgModifier");
            return (Criteria) this;
        }

        public Criteria andPvgModifiedTimeIsNull() {
            addCriterion("pvg_modified_time is null");
            return (Criteria) this;
        }

        public Criteria andPvgModifiedTimeIsNotNull() {
            addCriterion("pvg_modified_time is not null");
            return (Criteria) this;
        }

        public Criteria andPvgModifiedTimeEqualTo(Date value) {
            addCriterion("pvg_modified_time =", value, "pvgModifiedTime");
            return (Criteria) this;
        }

        public Criteria andPvgModifiedTimeNotEqualTo(Date value) {
            addCriterion("pvg_modified_time <>", value, "pvgModifiedTime");
            return (Criteria) this;
        }

        public Criteria andPvgModifiedTimeGreaterThan(Date value) {
            addCriterion("pvg_modified_time >", value, "pvgModifiedTime");
            return (Criteria) this;
        }

        public Criteria andPvgModifiedTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("pvg_modified_time >=", value, "pvgModifiedTime");
            return (Criteria) this;
        }

        public Criteria andPvgModifiedTimeLessThan(Date value) {
            addCriterion("pvg_modified_time <", value, "pvgModifiedTime");
            return (Criteria) this;
        }

        public Criteria andPvgModifiedTimeLessThanOrEqualTo(Date value) {
            addCriterion("pvg_modified_time <=", value, "pvgModifiedTime");
            return (Criteria) this;
        }

        public Criteria andPvgModifiedTimeIn(List<Date> values) {
            addCriterion("pvg_modified_time in", values, "pvgModifiedTime");
            return (Criteria) this;
        }

        public Criteria andPvgModifiedTimeNotIn(List<Date> values) {
            addCriterion("pvg_modified_time not in", values, "pvgModifiedTime");
            return (Criteria) this;
        }

        public Criteria andPvgModifiedTimeBetween(Date value1, Date value2) {
            addCriterion("pvg_modified_time between", value1, value2, "pvgModifiedTime");
            return (Criteria) this;
        }

        public Criteria andPvgModifiedTimeNotBetween(Date value1, Date value2) {
            addCriterion("pvg_modified_time not between", value1, value2, "pvgModifiedTime");
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