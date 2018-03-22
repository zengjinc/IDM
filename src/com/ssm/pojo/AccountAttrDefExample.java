package com.ssm.pojo;

import java.util.ArrayList;
import java.util.List;

public class AccountAttrDefExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AccountAttrDefExample() {
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

        public Criteria andAcctAttrDefKeyIsNull() {
            addCriterion("acct_attr_def_key is null");
            return (Criteria) this;
        }

        public Criteria andAcctAttrDefKeyIsNotNull() {
            addCriterion("acct_attr_def_key is not null");
            return (Criteria) this;
        }

        public Criteria andAcctAttrDefKeyEqualTo(String value) {
            addCriterion("acct_attr_def_key =", value, "acctAttrDefKey");
            return (Criteria) this;
        }

        public Criteria andAcctAttrDefKeyNotEqualTo(String value) {
            addCriterion("acct_attr_def_key <>", value, "acctAttrDefKey");
            return (Criteria) this;
        }

        public Criteria andAcctAttrDefKeyGreaterThan(String value) {
            addCriterion("acct_attr_def_key >", value, "acctAttrDefKey");
            return (Criteria) this;
        }

        public Criteria andAcctAttrDefKeyGreaterThanOrEqualTo(String value) {
            addCriterion("acct_attr_def_key >=", value, "acctAttrDefKey");
            return (Criteria) this;
        }

        public Criteria andAcctAttrDefKeyLessThan(String value) {
            addCriterion("acct_attr_def_key <", value, "acctAttrDefKey");
            return (Criteria) this;
        }

        public Criteria andAcctAttrDefKeyLessThanOrEqualTo(String value) {
            addCriterion("acct_attr_def_key <=", value, "acctAttrDefKey");
            return (Criteria) this;
        }

        public Criteria andAcctAttrDefKeyLike(String value) {
            addCriterion("acct_attr_def_key like", value, "acctAttrDefKey");
            return (Criteria) this;
        }

        public Criteria andAcctAttrDefKeyNotLike(String value) {
            addCriterion("acct_attr_def_key not like", value, "acctAttrDefKey");
            return (Criteria) this;
        }

        public Criteria andAcctAttrDefKeyIn(List<String> values) {
            addCriterion("acct_attr_def_key in", values, "acctAttrDefKey");
            return (Criteria) this;
        }

        public Criteria andAcctAttrDefKeyNotIn(List<String> values) {
            addCriterion("acct_attr_def_key not in", values, "acctAttrDefKey");
            return (Criteria) this;
        }

        public Criteria andAcctAttrDefKeyBetween(String value1, String value2) {
            addCriterion("acct_attr_def_key between", value1, value2, "acctAttrDefKey");
            return (Criteria) this;
        }

        public Criteria andAcctAttrDefKeyNotBetween(String value1, String value2) {
            addCriterion("acct_attr_def_key not between", value1, value2, "acctAttrDefKey");
            return (Criteria) this;
        }

        public Criteria andAcctAttrDefNameIsNull() {
            addCriterion("acct_attr_def_name is null");
            return (Criteria) this;
        }

        public Criteria andAcctAttrDefNameIsNotNull() {
            addCriterion("acct_attr_def_name is not null");
            return (Criteria) this;
        }

        public Criteria andAcctAttrDefNameEqualTo(String value) {
            addCriterion("acct_attr_def_name =", value, "acctAttrDefName");
            return (Criteria) this;
        }

        public Criteria andAcctAttrDefNameNotEqualTo(String value) {
            addCriterion("acct_attr_def_name <>", value, "acctAttrDefName");
            return (Criteria) this;
        }

        public Criteria andAcctAttrDefNameGreaterThan(String value) {
            addCriterion("acct_attr_def_name >", value, "acctAttrDefName");
            return (Criteria) this;
        }

        public Criteria andAcctAttrDefNameGreaterThanOrEqualTo(String value) {
            addCriterion("acct_attr_def_name >=", value, "acctAttrDefName");
            return (Criteria) this;
        }

        public Criteria andAcctAttrDefNameLessThan(String value) {
            addCriterion("acct_attr_def_name <", value, "acctAttrDefName");
            return (Criteria) this;
        }

        public Criteria andAcctAttrDefNameLessThanOrEqualTo(String value) {
            addCriterion("acct_attr_def_name <=", value, "acctAttrDefName");
            return (Criteria) this;
        }

        public Criteria andAcctAttrDefNameLike(String value) {
            addCriterion("acct_attr_def_name like", value, "acctAttrDefName");
            return (Criteria) this;
        }

        public Criteria andAcctAttrDefNameNotLike(String value) {
            addCriterion("acct_attr_def_name not like", value, "acctAttrDefName");
            return (Criteria) this;
        }

        public Criteria andAcctAttrDefNameIn(List<String> values) {
            addCriterion("acct_attr_def_name in", values, "acctAttrDefName");
            return (Criteria) this;
        }

        public Criteria andAcctAttrDefNameNotIn(List<String> values) {
            addCriterion("acct_attr_def_name not in", values, "acctAttrDefName");
            return (Criteria) this;
        }

        public Criteria andAcctAttrDefNameBetween(String value1, String value2) {
            addCriterion("acct_attr_def_name between", value1, value2, "acctAttrDefName");
            return (Criteria) this;
        }

        public Criteria andAcctAttrDefNameNotBetween(String value1, String value2) {
            addCriterion("acct_attr_def_name not between", value1, value2, "acctAttrDefName");
            return (Criteria) this;
        }

        public Criteria andAcctAttrDefDatatypeIsNull() {
            addCriterion("acct_attr_def_datatype is null");
            return (Criteria) this;
        }

        public Criteria andAcctAttrDefDatatypeIsNotNull() {
            addCriterion("acct_attr_def_datatype is not null");
            return (Criteria) this;
        }

        public Criteria andAcctAttrDefDatatypeEqualTo(String value) {
            addCriterion("acct_attr_def_datatype =", value, "acctAttrDefDatatype");
            return (Criteria) this;
        }

        public Criteria andAcctAttrDefDatatypeNotEqualTo(String value) {
            addCriterion("acct_attr_def_datatype <>", value, "acctAttrDefDatatype");
            return (Criteria) this;
        }

        public Criteria andAcctAttrDefDatatypeGreaterThan(String value) {
            addCriterion("acct_attr_def_datatype >", value, "acctAttrDefDatatype");
            return (Criteria) this;
        }

        public Criteria andAcctAttrDefDatatypeGreaterThanOrEqualTo(String value) {
            addCriterion("acct_attr_def_datatype >=", value, "acctAttrDefDatatype");
            return (Criteria) this;
        }

        public Criteria andAcctAttrDefDatatypeLessThan(String value) {
            addCriterion("acct_attr_def_datatype <", value, "acctAttrDefDatatype");
            return (Criteria) this;
        }

        public Criteria andAcctAttrDefDatatypeLessThanOrEqualTo(String value) {
            addCriterion("acct_attr_def_datatype <=", value, "acctAttrDefDatatype");
            return (Criteria) this;
        }

        public Criteria andAcctAttrDefDatatypeLike(String value) {
            addCriterion("acct_attr_def_datatype like", value, "acctAttrDefDatatype");
            return (Criteria) this;
        }

        public Criteria andAcctAttrDefDatatypeNotLike(String value) {
            addCriterion("acct_attr_def_datatype not like", value, "acctAttrDefDatatype");
            return (Criteria) this;
        }

        public Criteria andAcctAttrDefDatatypeIn(List<String> values) {
            addCriterion("acct_attr_def_datatype in", values, "acctAttrDefDatatype");
            return (Criteria) this;
        }

        public Criteria andAcctAttrDefDatatypeNotIn(List<String> values) {
            addCriterion("acct_attr_def_datatype not in", values, "acctAttrDefDatatype");
            return (Criteria) this;
        }

        public Criteria andAcctAttrDefDatatypeBetween(String value1, String value2) {
            addCriterion("acct_attr_def_datatype between", value1, value2, "acctAttrDefDatatype");
            return (Criteria) this;
        }

        public Criteria andAcctAttrDefDatatypeNotBetween(String value1, String value2) {
            addCriterion("acct_attr_def_datatype not between", value1, value2, "acctAttrDefDatatype");
            return (Criteria) this;
        }

        public Criteria andAcctAttrDefMandatoryIsNull() {
            addCriterion("acct_attr_def_mandatory is null");
            return (Criteria) this;
        }

        public Criteria andAcctAttrDefMandatoryIsNotNull() {
            addCriterion("acct_attr_def_mandatory is not null");
            return (Criteria) this;
        }

        public Criteria andAcctAttrDefMandatoryEqualTo(Integer value) {
            addCriterion("acct_attr_def_mandatory =", value, "acctAttrDefMandatory");
            return (Criteria) this;
        }

        public Criteria andAcctAttrDefMandatoryNotEqualTo(Integer value) {
            addCriterion("acct_attr_def_mandatory <>", value, "acctAttrDefMandatory");
            return (Criteria) this;
        }

        public Criteria andAcctAttrDefMandatoryGreaterThan(Integer value) {
            addCriterion("acct_attr_def_mandatory >", value, "acctAttrDefMandatory");
            return (Criteria) this;
        }

        public Criteria andAcctAttrDefMandatoryGreaterThanOrEqualTo(Integer value) {
            addCriterion("acct_attr_def_mandatory >=", value, "acctAttrDefMandatory");
            return (Criteria) this;
        }

        public Criteria andAcctAttrDefMandatoryLessThan(Integer value) {
            addCriterion("acct_attr_def_mandatory <", value, "acctAttrDefMandatory");
            return (Criteria) this;
        }

        public Criteria andAcctAttrDefMandatoryLessThanOrEqualTo(Integer value) {
            addCriterion("acct_attr_def_mandatory <=", value, "acctAttrDefMandatory");
            return (Criteria) this;
        }

        public Criteria andAcctAttrDefMandatoryIn(List<Integer> values) {
            addCriterion("acct_attr_def_mandatory in", values, "acctAttrDefMandatory");
            return (Criteria) this;
        }

        public Criteria andAcctAttrDefMandatoryNotIn(List<Integer> values) {
            addCriterion("acct_attr_def_mandatory not in", values, "acctAttrDefMandatory");
            return (Criteria) this;
        }

        public Criteria andAcctAttrDefMandatoryBetween(Integer value1, Integer value2) {
            addCriterion("acct_attr_def_mandatory between", value1, value2, "acctAttrDefMandatory");
            return (Criteria) this;
        }

        public Criteria andAcctAttrDefMandatoryNotBetween(Integer value1, Integer value2) {
            addCriterion("acct_attr_def_mandatory not between", value1, value2, "acctAttrDefMandatory");
            return (Criteria) this;
        }

        public Criteria andAcctAttrDefEditableIsNull() {
            addCriterion("acct_attr_def_editable is null");
            return (Criteria) this;
        }

        public Criteria andAcctAttrDefEditableIsNotNull() {
            addCriterion("acct_attr_def_editable is not null");
            return (Criteria) this;
        }

        public Criteria andAcctAttrDefEditableEqualTo(Integer value) {
            addCriterion("acct_attr_def_editable =", value, "acctAttrDefEditable");
            return (Criteria) this;
        }

        public Criteria andAcctAttrDefEditableNotEqualTo(Integer value) {
            addCriterion("acct_attr_def_editable <>", value, "acctAttrDefEditable");
            return (Criteria) this;
        }

        public Criteria andAcctAttrDefEditableGreaterThan(Integer value) {
            addCriterion("acct_attr_def_editable >", value, "acctAttrDefEditable");
            return (Criteria) this;
        }

        public Criteria andAcctAttrDefEditableGreaterThanOrEqualTo(Integer value) {
            addCriterion("acct_attr_def_editable >=", value, "acctAttrDefEditable");
            return (Criteria) this;
        }

        public Criteria andAcctAttrDefEditableLessThan(Integer value) {
            addCriterion("acct_attr_def_editable <", value, "acctAttrDefEditable");
            return (Criteria) this;
        }

        public Criteria andAcctAttrDefEditableLessThanOrEqualTo(Integer value) {
            addCriterion("acct_attr_def_editable <=", value, "acctAttrDefEditable");
            return (Criteria) this;
        }

        public Criteria andAcctAttrDefEditableIn(List<Integer> values) {
            addCriterion("acct_attr_def_editable in", values, "acctAttrDefEditable");
            return (Criteria) this;
        }

        public Criteria andAcctAttrDefEditableNotIn(List<Integer> values) {
            addCriterion("acct_attr_def_editable not in", values, "acctAttrDefEditable");
            return (Criteria) this;
        }

        public Criteria andAcctAttrDefEditableBetween(Integer value1, Integer value2) {
            addCriterion("acct_attr_def_editable between", value1, value2, "acctAttrDefEditable");
            return (Criteria) this;
        }

        public Criteria andAcctAttrDefEditableNotBetween(Integer value1, Integer value2) {
            addCriterion("acct_attr_def_editable not between", value1, value2, "acctAttrDefEditable");
            return (Criteria) this;
        }

        public Criteria andAcctAttrDefMaxIsNull() {
            addCriterion("acct_attr_def_max is null");
            return (Criteria) this;
        }

        public Criteria andAcctAttrDefMaxIsNotNull() {
            addCriterion("acct_attr_def_max is not null");
            return (Criteria) this;
        }

        public Criteria andAcctAttrDefMaxEqualTo(String value) {
            addCriterion("acct_attr_def_max =", value, "acctAttrDefMax");
            return (Criteria) this;
        }

        public Criteria andAcctAttrDefMaxNotEqualTo(String value) {
            addCriterion("acct_attr_def_max <>", value, "acctAttrDefMax");
            return (Criteria) this;
        }

        public Criteria andAcctAttrDefMaxGreaterThan(String value) {
            addCriterion("acct_attr_def_max >", value, "acctAttrDefMax");
            return (Criteria) this;
        }

        public Criteria andAcctAttrDefMaxGreaterThanOrEqualTo(String value) {
            addCriterion("acct_attr_def_max >=", value, "acctAttrDefMax");
            return (Criteria) this;
        }

        public Criteria andAcctAttrDefMaxLessThan(String value) {
            addCriterion("acct_attr_def_max <", value, "acctAttrDefMax");
            return (Criteria) this;
        }

        public Criteria andAcctAttrDefMaxLessThanOrEqualTo(String value) {
            addCriterion("acct_attr_def_max <=", value, "acctAttrDefMax");
            return (Criteria) this;
        }

        public Criteria andAcctAttrDefMaxLike(String value) {
            addCriterion("acct_attr_def_max like", value, "acctAttrDefMax");
            return (Criteria) this;
        }

        public Criteria andAcctAttrDefMaxNotLike(String value) {
            addCriterion("acct_attr_def_max not like", value, "acctAttrDefMax");
            return (Criteria) this;
        }

        public Criteria andAcctAttrDefMaxIn(List<String> values) {
            addCriterion("acct_attr_def_max in", values, "acctAttrDefMax");
            return (Criteria) this;
        }

        public Criteria andAcctAttrDefMaxNotIn(List<String> values) {
            addCriterion("acct_attr_def_max not in", values, "acctAttrDefMax");
            return (Criteria) this;
        }

        public Criteria andAcctAttrDefMaxBetween(String value1, String value2) {
            addCriterion("acct_attr_def_max between", value1, value2, "acctAttrDefMax");
            return (Criteria) this;
        }

        public Criteria andAcctAttrDefMaxNotBetween(String value1, String value2) {
            addCriterion("acct_attr_def_max not between", value1, value2, "acctAttrDefMax");
            return (Criteria) this;
        }

        public Criteria andAcctAttrDefMinIsNull() {
            addCriterion("acct_attr_def_min is null");
            return (Criteria) this;
        }

        public Criteria andAcctAttrDefMinIsNotNull() {
            addCriterion("acct_attr_def_min is not null");
            return (Criteria) this;
        }

        public Criteria andAcctAttrDefMinEqualTo(String value) {
            addCriterion("acct_attr_def_min =", value, "acctAttrDefMin");
            return (Criteria) this;
        }

        public Criteria andAcctAttrDefMinNotEqualTo(String value) {
            addCriterion("acct_attr_def_min <>", value, "acctAttrDefMin");
            return (Criteria) this;
        }

        public Criteria andAcctAttrDefMinGreaterThan(String value) {
            addCriterion("acct_attr_def_min >", value, "acctAttrDefMin");
            return (Criteria) this;
        }

        public Criteria andAcctAttrDefMinGreaterThanOrEqualTo(String value) {
            addCriterion("acct_attr_def_min >=", value, "acctAttrDefMin");
            return (Criteria) this;
        }

        public Criteria andAcctAttrDefMinLessThan(String value) {
            addCriterion("acct_attr_def_min <", value, "acctAttrDefMin");
            return (Criteria) this;
        }

        public Criteria andAcctAttrDefMinLessThanOrEqualTo(String value) {
            addCriterion("acct_attr_def_min <=", value, "acctAttrDefMin");
            return (Criteria) this;
        }

        public Criteria andAcctAttrDefMinLike(String value) {
            addCriterion("acct_attr_def_min like", value, "acctAttrDefMin");
            return (Criteria) this;
        }

        public Criteria andAcctAttrDefMinNotLike(String value) {
            addCriterion("acct_attr_def_min not like", value, "acctAttrDefMin");
            return (Criteria) this;
        }

        public Criteria andAcctAttrDefMinIn(List<String> values) {
            addCriterion("acct_attr_def_min in", values, "acctAttrDefMin");
            return (Criteria) this;
        }

        public Criteria andAcctAttrDefMinNotIn(List<String> values) {
            addCriterion("acct_attr_def_min not in", values, "acctAttrDefMin");
            return (Criteria) this;
        }

        public Criteria andAcctAttrDefMinBetween(String value1, String value2) {
            addCriterion("acct_attr_def_min between", value1, value2, "acctAttrDefMin");
            return (Criteria) this;
        }

        public Criteria andAcctAttrDefMinNotBetween(String value1, String value2) {
            addCriterion("acct_attr_def_min not between", value1, value2, "acctAttrDefMin");
            return (Criteria) this;
        }

        public Criteria andAcctAttrDefResUuidIsNull() {
            addCriterion("acct_attr_def_res_uuid is null");
            return (Criteria) this;
        }

        public Criteria andAcctAttrDefResUuidIsNotNull() {
            addCriterion("acct_attr_def_res_uuid is not null");
            return (Criteria) this;
        }

        public Criteria andAcctAttrDefResUuidEqualTo(String value) {
            addCriterion("acct_attr_def_res_uuid =", value, "acctAttrDefResUuid");
            return (Criteria) this;
        }

        public Criteria andAcctAttrDefResUuidNotEqualTo(String value) {
            addCriterion("acct_attr_def_res_uuid <>", value, "acctAttrDefResUuid");
            return (Criteria) this;
        }

        public Criteria andAcctAttrDefResUuidGreaterThan(String value) {
            addCriterion("acct_attr_def_res_uuid >", value, "acctAttrDefResUuid");
            return (Criteria) this;
        }

        public Criteria andAcctAttrDefResUuidGreaterThanOrEqualTo(String value) {
            addCriterion("acct_attr_def_res_uuid >=", value, "acctAttrDefResUuid");
            return (Criteria) this;
        }

        public Criteria andAcctAttrDefResUuidLessThan(String value) {
            addCriterion("acct_attr_def_res_uuid <", value, "acctAttrDefResUuid");
            return (Criteria) this;
        }

        public Criteria andAcctAttrDefResUuidLessThanOrEqualTo(String value) {
            addCriterion("acct_attr_def_res_uuid <=", value, "acctAttrDefResUuid");
            return (Criteria) this;
        }

        public Criteria andAcctAttrDefResUuidLike(String value) {
            addCriterion("acct_attr_def_res_uuid like", value, "acctAttrDefResUuid");
            return (Criteria) this;
        }

        public Criteria andAcctAttrDefResUuidNotLike(String value) {
            addCriterion("acct_attr_def_res_uuid not like", value, "acctAttrDefResUuid");
            return (Criteria) this;
        }

        public Criteria andAcctAttrDefResUuidIn(List<String> values) {
            addCriterion("acct_attr_def_res_uuid in", values, "acctAttrDefResUuid");
            return (Criteria) this;
        }

        public Criteria andAcctAttrDefResUuidNotIn(List<String> values) {
            addCriterion("acct_attr_def_res_uuid not in", values, "acctAttrDefResUuid");
            return (Criteria) this;
        }

        public Criteria andAcctAttrDefResUuidBetween(String value1, String value2) {
            addCriterion("acct_attr_def_res_uuid between", value1, value2, "acctAttrDefResUuid");
            return (Criteria) this;
        }

        public Criteria andAcctAttrDefResUuidNotBetween(String value1, String value2) {
            addCriterion("acct_attr_def_res_uuid not between", value1, value2, "acctAttrDefResUuid");
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