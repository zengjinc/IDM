package com.ssm.pojo;

import java.util.ArrayList;
import java.util.List;

public class RelUserBizroleExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RelUserBizroleExample() {
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

        public Criteria andRelUserBizroleUserUuidIsNull() {
            addCriterion("rel_user_bizrole_user_uuid is null");
            return (Criteria) this;
        }

        public Criteria andRelUserBizroleUserUuidIsNotNull() {
            addCriterion("rel_user_bizrole_user_uuid is not null");
            return (Criteria) this;
        }

        public Criteria andRelUserBizroleUserUuidEqualTo(String value) {
            addCriterion("rel_user_bizrole_user_uuid =", value, "relUserBizroleUserUuid");
            return (Criteria) this;
        }

        public Criteria andRelUserBizroleUserUuidNotEqualTo(String value) {
            addCriterion("rel_user_bizrole_user_uuid <>", value, "relUserBizroleUserUuid");
            return (Criteria) this;
        }

        public Criteria andRelUserBizroleUserUuidGreaterThan(String value) {
            addCriterion("rel_user_bizrole_user_uuid >", value, "relUserBizroleUserUuid");
            return (Criteria) this;
        }

        public Criteria andRelUserBizroleUserUuidGreaterThanOrEqualTo(String value) {
            addCriterion("rel_user_bizrole_user_uuid >=", value, "relUserBizroleUserUuid");
            return (Criteria) this;
        }

        public Criteria andRelUserBizroleUserUuidLessThan(String value) {
            addCriterion("rel_user_bizrole_user_uuid <", value, "relUserBizroleUserUuid");
            return (Criteria) this;
        }

        public Criteria andRelUserBizroleUserUuidLessThanOrEqualTo(String value) {
            addCriterion("rel_user_bizrole_user_uuid <=", value, "relUserBizroleUserUuid");
            return (Criteria) this;
        }

        public Criteria andRelUserBizroleUserUuidLike(String value) {
            addCriterion("rel_user_bizrole_user_uuid like", value, "relUserBizroleUserUuid");
            return (Criteria) this;
        }

        public Criteria andRelUserBizroleUserUuidNotLike(String value) {
            addCriterion("rel_user_bizrole_user_uuid not like", value, "relUserBizroleUserUuid");
            return (Criteria) this;
        }

        public Criteria andRelUserBizroleUserUuidIn(List<String> values) {
            addCriterion("rel_user_bizrole_user_uuid in", values, "relUserBizroleUserUuid");
            return (Criteria) this;
        }

        public Criteria andRelUserBizroleUserUuidNotIn(List<String> values) {
            addCriterion("rel_user_bizrole_user_uuid not in", values, "relUserBizroleUserUuid");
            return (Criteria) this;
        }

        public Criteria andRelUserBizroleUserUuidBetween(String value1, String value2) {
            addCriterion("rel_user_bizrole_user_uuid between", value1, value2, "relUserBizroleUserUuid");
            return (Criteria) this;
        }

        public Criteria andRelUserBizroleUserUuidNotBetween(String value1, String value2) {
            addCriterion("rel_user_bizrole_user_uuid not between", value1, value2, "relUserBizroleUserUuid");
            return (Criteria) this;
        }

        public Criteria andRelUserBizroleBizroleUuidIsNull() {
            addCriterion("rel_user_bizrole_bizrole_uuid is null");
            return (Criteria) this;
        }

        public Criteria andRelUserBizroleBizroleUuidIsNotNull() {
            addCriterion("rel_user_bizrole_bizrole_uuid is not null");
            return (Criteria) this;
        }

        public Criteria andRelUserBizroleBizroleUuidEqualTo(String value) {
            addCriterion("rel_user_bizrole_bizrole_uuid =", value, "relUserBizroleBizroleUuid");
            return (Criteria) this;
        }

        public Criteria andRelUserBizroleBizroleUuidNotEqualTo(String value) {
            addCriterion("rel_user_bizrole_bizrole_uuid <>", value, "relUserBizroleBizroleUuid");
            return (Criteria) this;
        }

        public Criteria andRelUserBizroleBizroleUuidGreaterThan(String value) {
            addCriterion("rel_user_bizrole_bizrole_uuid >", value, "relUserBizroleBizroleUuid");
            return (Criteria) this;
        }

        public Criteria andRelUserBizroleBizroleUuidGreaterThanOrEqualTo(String value) {
            addCriterion("rel_user_bizrole_bizrole_uuid >=", value, "relUserBizroleBizroleUuid");
            return (Criteria) this;
        }

        public Criteria andRelUserBizroleBizroleUuidLessThan(String value) {
            addCriterion("rel_user_bizrole_bizrole_uuid <", value, "relUserBizroleBizroleUuid");
            return (Criteria) this;
        }

        public Criteria andRelUserBizroleBizroleUuidLessThanOrEqualTo(String value) {
            addCriterion("rel_user_bizrole_bizrole_uuid <=", value, "relUserBizroleBizroleUuid");
            return (Criteria) this;
        }

        public Criteria andRelUserBizroleBizroleUuidLike(String value) {
            addCriterion("rel_user_bizrole_bizrole_uuid like", value, "relUserBizroleBizroleUuid");
            return (Criteria) this;
        }

        public Criteria andRelUserBizroleBizroleUuidNotLike(String value) {
            addCriterion("rel_user_bizrole_bizrole_uuid not like", value, "relUserBizroleBizroleUuid");
            return (Criteria) this;
        }

        public Criteria andRelUserBizroleBizroleUuidIn(List<String> values) {
            addCriterion("rel_user_bizrole_bizrole_uuid in", values, "relUserBizroleBizroleUuid");
            return (Criteria) this;
        }

        public Criteria andRelUserBizroleBizroleUuidNotIn(List<String> values) {
            addCriterion("rel_user_bizrole_bizrole_uuid not in", values, "relUserBizroleBizroleUuid");
            return (Criteria) this;
        }

        public Criteria andRelUserBizroleBizroleUuidBetween(String value1, String value2) {
            addCriterion("rel_user_bizrole_bizrole_uuid between", value1, value2, "relUserBizroleBizroleUuid");
            return (Criteria) this;
        }

        public Criteria andRelUserBizroleBizroleUuidNotBetween(String value1, String value2) {
            addCriterion("rel_user_bizrole_bizrole_uuid not between", value1, value2, "relUserBizroleBizroleUuid");
            return (Criteria) this;
        }

        public Criteria andRelUserBizroleDescIsNull() {
            addCriterion("rel_user_bizrole_desc is null");
            return (Criteria) this;
        }

        public Criteria andRelUserBizroleDescIsNotNull() {
            addCriterion("rel_user_bizrole_desc is not null");
            return (Criteria) this;
        }

        public Criteria andRelUserBizroleDescEqualTo(String value) {
            addCriterion("rel_user_bizrole_desc =", value, "relUserBizroleDesc");
            return (Criteria) this;
        }

        public Criteria andRelUserBizroleDescNotEqualTo(String value) {
            addCriterion("rel_user_bizrole_desc <>", value, "relUserBizroleDesc");
            return (Criteria) this;
        }

        public Criteria andRelUserBizroleDescGreaterThan(String value) {
            addCriterion("rel_user_bizrole_desc >", value, "relUserBizroleDesc");
            return (Criteria) this;
        }

        public Criteria andRelUserBizroleDescGreaterThanOrEqualTo(String value) {
            addCriterion("rel_user_bizrole_desc >=", value, "relUserBizroleDesc");
            return (Criteria) this;
        }

        public Criteria andRelUserBizroleDescLessThan(String value) {
            addCriterion("rel_user_bizrole_desc <", value, "relUserBizroleDesc");
            return (Criteria) this;
        }

        public Criteria andRelUserBizroleDescLessThanOrEqualTo(String value) {
            addCriterion("rel_user_bizrole_desc <=", value, "relUserBizroleDesc");
            return (Criteria) this;
        }

        public Criteria andRelUserBizroleDescLike(String value) {
            addCriterion("rel_user_bizrole_desc like", value, "relUserBizroleDesc");
            return (Criteria) this;
        }

        public Criteria andRelUserBizroleDescNotLike(String value) {
            addCriterion("rel_user_bizrole_desc not like", value, "relUserBizroleDesc");
            return (Criteria) this;
        }

        public Criteria andRelUserBizroleDescIn(List<String> values) {
            addCriterion("rel_user_bizrole_desc in", values, "relUserBizroleDesc");
            return (Criteria) this;
        }

        public Criteria andRelUserBizroleDescNotIn(List<String> values) {
            addCriterion("rel_user_bizrole_desc not in", values, "relUserBizroleDesc");
            return (Criteria) this;
        }

        public Criteria andRelUserBizroleDescBetween(String value1, String value2) {
            addCriterion("rel_user_bizrole_desc between", value1, value2, "relUserBizroleDesc");
            return (Criteria) this;
        }

        public Criteria andRelUserBizroleDescNotBetween(String value1, String value2) {
            addCriterion("rel_user_bizrole_desc not between", value1, value2, "relUserBizroleDesc");
            return (Criteria) this;
        }

        public Criteria andRelUserBizrolePolUuidIsNull() {
            addCriterion("rel_user_bizrole_pol_uuid is null");
            return (Criteria) this;
        }

        public Criteria andRelUserBizrolePolUuidIsNotNull() {
            addCriterion("rel_user_bizrole_pol_uuid is not null");
            return (Criteria) this;
        }

        public Criteria andRelUserBizrolePolUuidEqualTo(String value) {
            addCriterion("rel_user_bizrole_pol_uuid =", value, "relUserBizrolePolUuid");
            return (Criteria) this;
        }

        public Criteria andRelUserBizrolePolUuidNotEqualTo(String value) {
            addCriterion("rel_user_bizrole_pol_uuid <>", value, "relUserBizrolePolUuid");
            return (Criteria) this;
        }

        public Criteria andRelUserBizrolePolUuidGreaterThan(String value) {
            addCriterion("rel_user_bizrole_pol_uuid >", value, "relUserBizrolePolUuid");
            return (Criteria) this;
        }

        public Criteria andRelUserBizrolePolUuidGreaterThanOrEqualTo(String value) {
            addCriterion("rel_user_bizrole_pol_uuid >=", value, "relUserBizrolePolUuid");
            return (Criteria) this;
        }

        public Criteria andRelUserBizrolePolUuidLessThan(String value) {
            addCriterion("rel_user_bizrole_pol_uuid <", value, "relUserBizrolePolUuid");
            return (Criteria) this;
        }

        public Criteria andRelUserBizrolePolUuidLessThanOrEqualTo(String value) {
            addCriterion("rel_user_bizrole_pol_uuid <=", value, "relUserBizrolePolUuid");
            return (Criteria) this;
        }

        public Criteria andRelUserBizrolePolUuidLike(String value) {
            addCriterion("rel_user_bizrole_pol_uuid like", value, "relUserBizrolePolUuid");
            return (Criteria) this;
        }

        public Criteria andRelUserBizrolePolUuidNotLike(String value) {
            addCriterion("rel_user_bizrole_pol_uuid not like", value, "relUserBizrolePolUuid");
            return (Criteria) this;
        }

        public Criteria andRelUserBizrolePolUuidIn(List<String> values) {
            addCriterion("rel_user_bizrole_pol_uuid in", values, "relUserBizrolePolUuid");
            return (Criteria) this;
        }

        public Criteria andRelUserBizrolePolUuidNotIn(List<String> values) {
            addCriterion("rel_user_bizrole_pol_uuid not in", values, "relUserBizrolePolUuid");
            return (Criteria) this;
        }

        public Criteria andRelUserBizrolePolUuidBetween(String value1, String value2) {
            addCriterion("rel_user_bizrole_pol_uuid between", value1, value2, "relUserBizrolePolUuid");
            return (Criteria) this;
        }

        public Criteria andRelUserBizrolePolUuidNotBetween(String value1, String value2) {
            addCriterion("rel_user_bizrole_pol_uuid not between", value1, value2, "relUserBizrolePolUuid");
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