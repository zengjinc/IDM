package com.ssm.pojo;

import java.util.ArrayList;
import java.util.List;

public class ResourceExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ResourceExample() {
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

        public Criteria andResUuidIsNull() {
            addCriterion("res_uuid is null");
            return (Criteria) this;
        }

        public Criteria andResUuidIsNotNull() {
            addCriterion("res_uuid is not null");
            return (Criteria) this;
        }

        public Criteria andResUuidEqualTo(String value) {
            addCriterion("res_uuid =", value, "resUuid");
            return (Criteria) this;
        }

        public Criteria andResUuidNotEqualTo(String value) {
            addCriterion("res_uuid <>", value, "resUuid");
            return (Criteria) this;
        }

        public Criteria andResUuidGreaterThan(String value) {
            addCriterion("res_uuid >", value, "resUuid");
            return (Criteria) this;
        }

        public Criteria andResUuidGreaterThanOrEqualTo(String value) {
            addCriterion("res_uuid >=", value, "resUuid");
            return (Criteria) this;
        }

        public Criteria andResUuidLessThan(String value) {
            addCriterion("res_uuid <", value, "resUuid");
            return (Criteria) this;
        }

        public Criteria andResUuidLessThanOrEqualTo(String value) {
            addCriterion("res_uuid <=", value, "resUuid");
            return (Criteria) this;
        }

        public Criteria andResUuidLike(String value) {
            addCriterion("res_uuid like", value, "resUuid");
            return (Criteria) this;
        }

        public Criteria andResUuidNotLike(String value) {
            addCriterion("res_uuid not like", value, "resUuid");
            return (Criteria) this;
        }

        public Criteria andResUuidIn(List<String> values) {
            addCriterion("res_uuid in", values, "resUuid");
            return (Criteria) this;
        }

        public Criteria andResUuidNotIn(List<String> values) {
            addCriterion("res_uuid not in", values, "resUuid");
            return (Criteria) this;
        }

        public Criteria andResUuidBetween(String value1, String value2) {
            addCriterion("res_uuid between", value1, value2, "resUuid");
            return (Criteria) this;
        }

        public Criteria andResUuidNotBetween(String value1, String value2) {
            addCriterion("res_uuid not between", value1, value2, "resUuid");
            return (Criteria) this;
        }

        public Criteria andResIdIsNull() {
            addCriterion("res_id is null");
            return (Criteria) this;
        }

        public Criteria andResIdIsNotNull() {
            addCriterion("res_id is not null");
            return (Criteria) this;
        }

        public Criteria andResIdEqualTo(String value) {
            addCriterion("res_id =", value, "resId");
            return (Criteria) this;
        }

        public Criteria andResIdNotEqualTo(String value) {
            addCriterion("res_id <>", value, "resId");
            return (Criteria) this;
        }

        public Criteria andResIdGreaterThan(String value) {
            addCriterion("res_id >", value, "resId");
            return (Criteria) this;
        }

        public Criteria andResIdGreaterThanOrEqualTo(String value) {
            addCriterion("res_id >=", value, "resId");
            return (Criteria) this;
        }

        public Criteria andResIdLessThan(String value) {
            addCriterion("res_id <", value, "resId");
            return (Criteria) this;
        }

        public Criteria andResIdLessThanOrEqualTo(String value) {
            addCriterion("res_id <=", value, "resId");
            return (Criteria) this;
        }

        public Criteria andResIdLike(String value) {
            addCriterion("res_id like", value, "resId");
            return (Criteria) this;
        }

        public Criteria andResIdNotLike(String value) {
            addCriterion("res_id not like", value, "resId");
            return (Criteria) this;
        }

        public Criteria andResIdIn(List<String> values) {
            addCriterion("res_id in", values, "resId");
            return (Criteria) this;
        }

        public Criteria andResIdNotIn(List<String> values) {
            addCriterion("res_id not in", values, "resId");
            return (Criteria) this;
        }

        public Criteria andResIdBetween(String value1, String value2) {
            addCriterion("res_id between", value1, value2, "resId");
            return (Criteria) this;
        }

        public Criteria andResIdNotBetween(String value1, String value2) {
            addCriterion("res_id not between", value1, value2, "resId");
            return (Criteria) this;
        }

        public Criteria andResNameIsNull() {
            addCriterion("res_name is null");
            return (Criteria) this;
        }

        public Criteria andResNameIsNotNull() {
            addCriterion("res_name is not null");
            return (Criteria) this;
        }

        public Criteria andResNameEqualTo(String value) {
            addCriterion("res_name =", value, "resName");
            return (Criteria) this;
        }

        public Criteria andResNameNotEqualTo(String value) {
            addCriterion("res_name <>", value, "resName");
            return (Criteria) this;
        }

        public Criteria andResNameGreaterThan(String value) {
            addCriterion("res_name >", value, "resName");
            return (Criteria) this;
        }

        public Criteria andResNameGreaterThanOrEqualTo(String value) {
            addCriterion("res_name >=", value, "resName");
            return (Criteria) this;
        }

        public Criteria andResNameLessThan(String value) {
            addCriterion("res_name <", value, "resName");
            return (Criteria) this;
        }

        public Criteria andResNameLessThanOrEqualTo(String value) {
            addCriterion("res_name <=", value, "resName");
            return (Criteria) this;
        }

        public Criteria andResNameLike(String value) {
            addCriterion("res_name like", value, "resName");
            return (Criteria) this;
        }

        public Criteria andResNameNotLike(String value) {
            addCriterion("res_name not like", value, "resName");
            return (Criteria) this;
        }

        public Criteria andResNameIn(List<String> values) {
            addCriterion("res_name in", values, "resName");
            return (Criteria) this;
        }

        public Criteria andResNameNotIn(List<String> values) {
            addCriterion("res_name not in", values, "resName");
            return (Criteria) this;
        }

        public Criteria andResNameBetween(String value1, String value2) {
            addCriterion("res_name between", value1, value2, "resName");
            return (Criteria) this;
        }

        public Criteria andResNameNotBetween(String value1, String value2) {
            addCriterion("res_name not between", value1, value2, "resName");
            return (Criteria) this;
        }

        public Criteria andResDescIsNull() {
            addCriterion("res_desc is null");
            return (Criteria) this;
        }

        public Criteria andResDescIsNotNull() {
            addCriterion("res_desc is not null");
            return (Criteria) this;
        }

        public Criteria andResDescEqualTo(String value) {
            addCriterion("res_desc =", value, "resDesc");
            return (Criteria) this;
        }

        public Criteria andResDescNotEqualTo(String value) {
            addCriterion("res_desc <>", value, "resDesc");
            return (Criteria) this;
        }

        public Criteria andResDescGreaterThan(String value) {
            addCriterion("res_desc >", value, "resDesc");
            return (Criteria) this;
        }

        public Criteria andResDescGreaterThanOrEqualTo(String value) {
            addCriterion("res_desc >=", value, "resDesc");
            return (Criteria) this;
        }

        public Criteria andResDescLessThan(String value) {
            addCriterion("res_desc <", value, "resDesc");
            return (Criteria) this;
        }

        public Criteria andResDescLessThanOrEqualTo(String value) {
            addCriterion("res_desc <=", value, "resDesc");
            return (Criteria) this;
        }

        public Criteria andResDescLike(String value) {
            addCriterion("res_desc like", value, "resDesc");
            return (Criteria) this;
        }

        public Criteria andResDescNotLike(String value) {
            addCriterion("res_desc not like", value, "resDesc");
            return (Criteria) this;
        }

        public Criteria andResDescIn(List<String> values) {
            addCriterion("res_desc in", values, "resDesc");
            return (Criteria) this;
        }

        public Criteria andResDescNotIn(List<String> values) {
            addCriterion("res_desc not in", values, "resDesc");
            return (Criteria) this;
        }

        public Criteria andResDescBetween(String value1, String value2) {
            addCriterion("res_desc between", value1, value2, "resDesc");
            return (Criteria) this;
        }

        public Criteria andResDescNotBetween(String value1, String value2) {
            addCriterion("res_desc not between", value1, value2, "resDesc");
            return (Criteria) this;
        }

        public Criteria andResTrustIsNull() {
            addCriterion("res_trust is null");
            return (Criteria) this;
        }

        public Criteria andResTrustIsNotNull() {
            addCriterion("res_trust is not null");
            return (Criteria) this;
        }

        public Criteria andResTrustEqualTo(Integer value) {
            addCriterion("res_trust =", value, "resTrust");
            return (Criteria) this;
        }

        public Criteria andResTrustNotEqualTo(Integer value) {
            addCriterion("res_trust <>", value, "resTrust");
            return (Criteria) this;
        }

        public Criteria andResTrustGreaterThan(Integer value) {
            addCriterion("res_trust >", value, "resTrust");
            return (Criteria) this;
        }

        public Criteria andResTrustGreaterThanOrEqualTo(Integer value) {
            addCriterion("res_trust >=", value, "resTrust");
            return (Criteria) this;
        }

        public Criteria andResTrustLessThan(Integer value) {
            addCriterion("res_trust <", value, "resTrust");
            return (Criteria) this;
        }

        public Criteria andResTrustLessThanOrEqualTo(Integer value) {
            addCriterion("res_trust <=", value, "resTrust");
            return (Criteria) this;
        }

        public Criteria andResTrustIn(List<Integer> values) {
            addCriterion("res_trust in", values, "resTrust");
            return (Criteria) this;
        }

        public Criteria andResTrustNotIn(List<Integer> values) {
            addCriterion("res_trust not in", values, "resTrust");
            return (Criteria) this;
        }

        public Criteria andResTrustBetween(Integer value1, Integer value2) {
            addCriterion("res_trust between", value1, value2, "resTrust");
            return (Criteria) this;
        }

        public Criteria andResTrustNotBetween(Integer value1, Integer value2) {
            addCriterion("res_trust not between", value1, value2, "resTrust");
            return (Criteria) this;
        }

        public Criteria andResTypeUuidIsNull() {
            addCriterion("res_type_uuid is null");
            return (Criteria) this;
        }

        public Criteria andResTypeUuidIsNotNull() {
            addCriterion("res_type_uuid is not null");
            return (Criteria) this;
        }

        public Criteria andResTypeUuidEqualTo(String value) {
            addCriterion("res_type_uuid =", value, "resTypeUuid");
            return (Criteria) this;
        }

        public Criteria andResTypeUuidNotEqualTo(String value) {
            addCriterion("res_type_uuid <>", value, "resTypeUuid");
            return (Criteria) this;
        }

        public Criteria andResTypeUuidGreaterThan(String value) {
            addCriterion("res_type_uuid >", value, "resTypeUuid");
            return (Criteria) this;
        }

        public Criteria andResTypeUuidGreaterThanOrEqualTo(String value) {
            addCriterion("res_type_uuid >=", value, "resTypeUuid");
            return (Criteria) this;
        }

        public Criteria andResTypeUuidLessThan(String value) {
            addCriterion("res_type_uuid <", value, "resTypeUuid");
            return (Criteria) this;
        }

        public Criteria andResTypeUuidLessThanOrEqualTo(String value) {
            addCriterion("res_type_uuid <=", value, "resTypeUuid");
            return (Criteria) this;
        }

        public Criteria andResTypeUuidLike(String value) {
            addCriterion("res_type_uuid like", value, "resTypeUuid");
            return (Criteria) this;
        }

        public Criteria andResTypeUuidNotLike(String value) {
            addCriterion("res_type_uuid not like", value, "resTypeUuid");
            return (Criteria) this;
        }

        public Criteria andResTypeUuidIn(List<String> values) {
            addCriterion("res_type_uuid in", values, "resTypeUuid");
            return (Criteria) this;
        }

        public Criteria andResTypeUuidNotIn(List<String> values) {
            addCriterion("res_type_uuid not in", values, "resTypeUuid");
            return (Criteria) this;
        }

        public Criteria andResTypeUuidBetween(String value1, String value2) {
            addCriterion("res_type_uuid between", value1, value2, "resTypeUuid");
            return (Criteria) this;
        }

        public Criteria andResTypeUuidNotBetween(String value1, String value2) {
            addCriterion("res_type_uuid not between", value1, value2, "resTypeUuid");
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