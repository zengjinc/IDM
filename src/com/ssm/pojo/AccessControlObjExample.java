package com.ssm.pojo;

import java.util.ArrayList;
import java.util.List;

public class AccessControlObjExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AccessControlObjExample() {
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

        public Criteria andObjCodeIsNull() {
            addCriterion("obj_code is null");
            return (Criteria) this;
        }

        public Criteria andObjCodeIsNotNull() {
            addCriterion("obj_code is not null");
            return (Criteria) this;
        }

        public Criteria andObjCodeEqualTo(Integer value) {
            addCriterion("obj_code =", value, "objCode");
            return (Criteria) this;
        }

        public Criteria andObjCodeNotEqualTo(Integer value) {
            addCriterion("obj_code <>", value, "objCode");
            return (Criteria) this;
        }

        public Criteria andObjCodeGreaterThan(Integer value) {
            addCriterion("obj_code >", value, "objCode");
            return (Criteria) this;
        }

        public Criteria andObjCodeGreaterThanOrEqualTo(Integer value) {
            addCriterion("obj_code >=", value, "objCode");
            return (Criteria) this;
        }

        public Criteria andObjCodeLessThan(Integer value) {
            addCriterion("obj_code <", value, "objCode");
            return (Criteria) this;
        }

        public Criteria andObjCodeLessThanOrEqualTo(Integer value) {
            addCriterion("obj_code <=", value, "objCode");
            return (Criteria) this;
        }

        public Criteria andObjCodeIn(List<Integer> values) {
            addCriterion("obj_code in", values, "objCode");
            return (Criteria) this;
        }

        public Criteria andObjCodeNotIn(List<Integer> values) {
            addCriterion("obj_code not in", values, "objCode");
            return (Criteria) this;
        }

        public Criteria andObjCodeBetween(Integer value1, Integer value2) {
            addCriterion("obj_code between", value1, value2, "objCode");
            return (Criteria) this;
        }

        public Criteria andObjCodeNotBetween(Integer value1, Integer value2) {
            addCriterion("obj_code not between", value1, value2, "objCode");
            return (Criteria) this;
        }

        public Criteria andObjNameIsNull() {
            addCriterion("obj_name is null");
            return (Criteria) this;
        }

        public Criteria andObjNameIsNotNull() {
            addCriterion("obj_name is not null");
            return (Criteria) this;
        }

        public Criteria andObjNameEqualTo(String value) {
            addCriterion("obj_name =", value, "objName");
            return (Criteria) this;
        }

        public Criteria andObjNameNotEqualTo(String value) {
            addCriterion("obj_name <>", value, "objName");
            return (Criteria) this;
        }

        public Criteria andObjNameGreaterThan(String value) {
            addCriterion("obj_name >", value, "objName");
            return (Criteria) this;
        }

        public Criteria andObjNameGreaterThanOrEqualTo(String value) {
            addCriterion("obj_name >=", value, "objName");
            return (Criteria) this;
        }

        public Criteria andObjNameLessThan(String value) {
            addCriterion("obj_name <", value, "objName");
            return (Criteria) this;
        }

        public Criteria andObjNameLessThanOrEqualTo(String value) {
            addCriterion("obj_name <=", value, "objName");
            return (Criteria) this;
        }

        public Criteria andObjNameLike(String value) {
            addCriterion("obj_name like", value, "objName");
            return (Criteria) this;
        }

        public Criteria andObjNameNotLike(String value) {
            addCriterion("obj_name not like", value, "objName");
            return (Criteria) this;
        }

        public Criteria andObjNameIn(List<String> values) {
            addCriterion("obj_name in", values, "objName");
            return (Criteria) this;
        }

        public Criteria andObjNameNotIn(List<String> values) {
            addCriterion("obj_name not in", values, "objName");
            return (Criteria) this;
        }

        public Criteria andObjNameBetween(String value1, String value2) {
            addCriterion("obj_name between", value1, value2, "objName");
            return (Criteria) this;
        }

        public Criteria andObjNameNotBetween(String value1, String value2) {
            addCriterion("obj_name not between", value1, value2, "objName");
            return (Criteria) this;
        }

        public Criteria andBojDescIsNull() {
            addCriterion("boj_desc is null");
            return (Criteria) this;
        }

        public Criteria andBojDescIsNotNull() {
            addCriterion("boj_desc is not null");
            return (Criteria) this;
        }

        public Criteria andBojDescEqualTo(String value) {
            addCriterion("boj_desc =", value, "bojDesc");
            return (Criteria) this;
        }

        public Criteria andBojDescNotEqualTo(String value) {
            addCriterion("boj_desc <>", value, "bojDesc");
            return (Criteria) this;
        }

        public Criteria andBojDescGreaterThan(String value) {
            addCriterion("boj_desc >", value, "bojDesc");
            return (Criteria) this;
        }

        public Criteria andBojDescGreaterThanOrEqualTo(String value) {
            addCriterion("boj_desc >=", value, "bojDesc");
            return (Criteria) this;
        }

        public Criteria andBojDescLessThan(String value) {
            addCriterion("boj_desc <", value, "bojDesc");
            return (Criteria) this;
        }

        public Criteria andBojDescLessThanOrEqualTo(String value) {
            addCriterion("boj_desc <=", value, "bojDesc");
            return (Criteria) this;
        }

        public Criteria andBojDescLike(String value) {
            addCriterion("boj_desc like", value, "bojDesc");
            return (Criteria) this;
        }

        public Criteria andBojDescNotLike(String value) {
            addCriterion("boj_desc not like", value, "bojDesc");
            return (Criteria) this;
        }

        public Criteria andBojDescIn(List<String> values) {
            addCriterion("boj_desc in", values, "bojDesc");
            return (Criteria) this;
        }

        public Criteria andBojDescNotIn(List<String> values) {
            addCriterion("boj_desc not in", values, "bojDesc");
            return (Criteria) this;
        }

        public Criteria andBojDescBetween(String value1, String value2) {
            addCriterion("boj_desc between", value1, value2, "bojDesc");
            return (Criteria) this;
        }

        public Criteria andBojDescNotBetween(String value1, String value2) {
            addCriterion("boj_desc not between", value1, value2, "bojDesc");
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