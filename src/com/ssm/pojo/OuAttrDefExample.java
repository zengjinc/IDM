package com.ssm.pojo;

import java.util.ArrayList;
import java.util.List;

public class OuAttrDefExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OuAttrDefExample() {
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

        public Criteria andOuAttrDefUuidIsNull() {
            addCriterion("ou_attr_def_uuid is null");
            return (Criteria) this;
        }

        public Criteria andOuAttrDefUuidIsNotNull() {
            addCriterion("ou_attr_def_uuid is not null");
            return (Criteria) this;
        }

        public Criteria andOuAttrDefUuidEqualTo(String value) {
            addCriterion("ou_attr_def_uuid =", value, "ouAttrDefUuid");
            return (Criteria) this;
        }

        public Criteria andOuAttrDefUuidNotEqualTo(String value) {
            addCriterion("ou_attr_def_uuid <>", value, "ouAttrDefUuid");
            return (Criteria) this;
        }

        public Criteria andOuAttrDefUuidGreaterThan(String value) {
            addCriterion("ou_attr_def_uuid >", value, "ouAttrDefUuid");
            return (Criteria) this;
        }

        public Criteria andOuAttrDefUuidGreaterThanOrEqualTo(String value) {
            addCriterion("ou_attr_def_uuid >=", value, "ouAttrDefUuid");
            return (Criteria) this;
        }

        public Criteria andOuAttrDefUuidLessThan(String value) {
            addCriterion("ou_attr_def_uuid <", value, "ouAttrDefUuid");
            return (Criteria) this;
        }

        public Criteria andOuAttrDefUuidLessThanOrEqualTo(String value) {
            addCriterion("ou_attr_def_uuid <=", value, "ouAttrDefUuid");
            return (Criteria) this;
        }

        public Criteria andOuAttrDefUuidLike(String value) {
            addCriterion("ou_attr_def_uuid like", value, "ouAttrDefUuid");
            return (Criteria) this;
        }

        public Criteria andOuAttrDefUuidNotLike(String value) {
            addCriterion("ou_attr_def_uuid not like", value, "ouAttrDefUuid");
            return (Criteria) this;
        }

        public Criteria andOuAttrDefUuidIn(List<String> values) {
            addCriterion("ou_attr_def_uuid in", values, "ouAttrDefUuid");
            return (Criteria) this;
        }

        public Criteria andOuAttrDefUuidNotIn(List<String> values) {
            addCriterion("ou_attr_def_uuid not in", values, "ouAttrDefUuid");
            return (Criteria) this;
        }

        public Criteria andOuAttrDefUuidBetween(String value1, String value2) {
            addCriterion("ou_attr_def_uuid between", value1, value2, "ouAttrDefUuid");
            return (Criteria) this;
        }

        public Criteria andOuAttrDefUuidNotBetween(String value1, String value2) {
            addCriterion("ou_attr_def_uuid not between", value1, value2, "ouAttrDefUuid");
            return (Criteria) this;
        }

        public Criteria andOuAttrDefKeyIsNull() {
            addCriterion("ou_attr_def_key is null");
            return (Criteria) this;
        }

        public Criteria andOuAttrDefKeyIsNotNull() {
            addCriterion("ou_attr_def_key is not null");
            return (Criteria) this;
        }

        public Criteria andOuAttrDefKeyEqualTo(String value) {
            addCriterion("ou_attr_def_key =", value, "ouAttrDefKey");
            return (Criteria) this;
        }

        public Criteria andOuAttrDefKeyNotEqualTo(String value) {
            addCriterion("ou_attr_def_key <>", value, "ouAttrDefKey");
            return (Criteria) this;
        }

        public Criteria andOuAttrDefKeyGreaterThan(String value) {
            addCriterion("ou_attr_def_key >", value, "ouAttrDefKey");
            return (Criteria) this;
        }

        public Criteria andOuAttrDefKeyGreaterThanOrEqualTo(String value) {
            addCriterion("ou_attr_def_key >=", value, "ouAttrDefKey");
            return (Criteria) this;
        }

        public Criteria andOuAttrDefKeyLessThan(String value) {
            addCriterion("ou_attr_def_key <", value, "ouAttrDefKey");
            return (Criteria) this;
        }

        public Criteria andOuAttrDefKeyLessThanOrEqualTo(String value) {
            addCriterion("ou_attr_def_key <=", value, "ouAttrDefKey");
            return (Criteria) this;
        }

        public Criteria andOuAttrDefKeyLike(String value) {
            addCriterion("ou_attr_def_key like", value, "ouAttrDefKey");
            return (Criteria) this;
        }

        public Criteria andOuAttrDefKeyNotLike(String value) {
            addCriterion("ou_attr_def_key not like", value, "ouAttrDefKey");
            return (Criteria) this;
        }

        public Criteria andOuAttrDefKeyIn(List<String> values) {
            addCriterion("ou_attr_def_key in", values, "ouAttrDefKey");
            return (Criteria) this;
        }

        public Criteria andOuAttrDefKeyNotIn(List<String> values) {
            addCriterion("ou_attr_def_key not in", values, "ouAttrDefKey");
            return (Criteria) this;
        }

        public Criteria andOuAttrDefKeyBetween(String value1, String value2) {
            addCriterion("ou_attr_def_key between", value1, value2, "ouAttrDefKey");
            return (Criteria) this;
        }

        public Criteria andOuAttrDefKeyNotBetween(String value1, String value2) {
            addCriterion("ou_attr_def_key not between", value1, value2, "ouAttrDefKey");
            return (Criteria) this;
        }

        public Criteria andOuAttrDefNameIsNull() {
            addCriterion("ou_attr_def_name is null");
            return (Criteria) this;
        }

        public Criteria andOuAttrDefNameIsNotNull() {
            addCriterion("ou_attr_def_name is not null");
            return (Criteria) this;
        }

        public Criteria andOuAttrDefNameEqualTo(String value) {
            addCriterion("ou_attr_def_name =", value, "ouAttrDefName");
            return (Criteria) this;
        }

        public Criteria andOuAttrDefNameNotEqualTo(String value) {
            addCriterion("ou_attr_def_name <>", value, "ouAttrDefName");
            return (Criteria) this;
        }

        public Criteria andOuAttrDefNameGreaterThan(String value) {
            addCriterion("ou_attr_def_name >", value, "ouAttrDefName");
            return (Criteria) this;
        }

        public Criteria andOuAttrDefNameGreaterThanOrEqualTo(String value) {
            addCriterion("ou_attr_def_name >=", value, "ouAttrDefName");
            return (Criteria) this;
        }

        public Criteria andOuAttrDefNameLessThan(String value) {
            addCriterion("ou_attr_def_name <", value, "ouAttrDefName");
            return (Criteria) this;
        }

        public Criteria andOuAttrDefNameLessThanOrEqualTo(String value) {
            addCriterion("ou_attr_def_name <=", value, "ouAttrDefName");
            return (Criteria) this;
        }

        public Criteria andOuAttrDefNameLike(String value) {
            addCriterion("ou_attr_def_name like", value, "ouAttrDefName");
            return (Criteria) this;
        }

        public Criteria andOuAttrDefNameNotLike(String value) {
            addCriterion("ou_attr_def_name not like", value, "ouAttrDefName");
            return (Criteria) this;
        }

        public Criteria andOuAttrDefNameIn(List<String> values) {
            addCriterion("ou_attr_def_name in", values, "ouAttrDefName");
            return (Criteria) this;
        }

        public Criteria andOuAttrDefNameNotIn(List<String> values) {
            addCriterion("ou_attr_def_name not in", values, "ouAttrDefName");
            return (Criteria) this;
        }

        public Criteria andOuAttrDefNameBetween(String value1, String value2) {
            addCriterion("ou_attr_def_name between", value1, value2, "ouAttrDefName");
            return (Criteria) this;
        }

        public Criteria andOuAttrDefNameNotBetween(String value1, String value2) {
            addCriterion("ou_attr_def_name not between", value1, value2, "ouAttrDefName");
            return (Criteria) this;
        }

        public Criteria andOuAttrDefDatatypeIsNull() {
            addCriterion("ou_attr_def_datatype is null");
            return (Criteria) this;
        }

        public Criteria andOuAttrDefDatatypeIsNotNull() {
            addCriterion("ou_attr_def_datatype is not null");
            return (Criteria) this;
        }

        public Criteria andOuAttrDefDatatypeEqualTo(String value) {
            addCriterion("ou_attr_def_datatype =", value, "ouAttrDefDatatype");
            return (Criteria) this;
        }

        public Criteria andOuAttrDefDatatypeNotEqualTo(String value) {
            addCriterion("ou_attr_def_datatype <>", value, "ouAttrDefDatatype");
            return (Criteria) this;
        }

        public Criteria andOuAttrDefDatatypeGreaterThan(String value) {
            addCriterion("ou_attr_def_datatype >", value, "ouAttrDefDatatype");
            return (Criteria) this;
        }

        public Criteria andOuAttrDefDatatypeGreaterThanOrEqualTo(String value) {
            addCriterion("ou_attr_def_datatype >=", value, "ouAttrDefDatatype");
            return (Criteria) this;
        }

        public Criteria andOuAttrDefDatatypeLessThan(String value) {
            addCriterion("ou_attr_def_datatype <", value, "ouAttrDefDatatype");
            return (Criteria) this;
        }

        public Criteria andOuAttrDefDatatypeLessThanOrEqualTo(String value) {
            addCriterion("ou_attr_def_datatype <=", value, "ouAttrDefDatatype");
            return (Criteria) this;
        }

        public Criteria andOuAttrDefDatatypeLike(String value) {
            addCriterion("ou_attr_def_datatype like", value, "ouAttrDefDatatype");
            return (Criteria) this;
        }

        public Criteria andOuAttrDefDatatypeNotLike(String value) {
            addCriterion("ou_attr_def_datatype not like", value, "ouAttrDefDatatype");
            return (Criteria) this;
        }

        public Criteria andOuAttrDefDatatypeIn(List<String> values) {
            addCriterion("ou_attr_def_datatype in", values, "ouAttrDefDatatype");
            return (Criteria) this;
        }

        public Criteria andOuAttrDefDatatypeNotIn(List<String> values) {
            addCriterion("ou_attr_def_datatype not in", values, "ouAttrDefDatatype");
            return (Criteria) this;
        }

        public Criteria andOuAttrDefDatatypeBetween(String value1, String value2) {
            addCriterion("ou_attr_def_datatype between", value1, value2, "ouAttrDefDatatype");
            return (Criteria) this;
        }

        public Criteria andOuAttrDefDatatypeNotBetween(String value1, String value2) {
            addCriterion("ou_attr_def_datatype not between", value1, value2, "ouAttrDefDatatype");
            return (Criteria) this;
        }

        public Criteria andOuAttrDefMandatoryIsNull() {
            addCriterion("ou_attr_def_mandatory is null");
            return (Criteria) this;
        }

        public Criteria andOuAttrDefMandatoryIsNotNull() {
            addCriterion("ou_attr_def_mandatory is not null");
            return (Criteria) this;
        }

        public Criteria andOuAttrDefMandatoryEqualTo(Integer value) {
            addCriterion("ou_attr_def_mandatory =", value, "ouAttrDefMandatory");
            return (Criteria) this;
        }

        public Criteria andOuAttrDefMandatoryNotEqualTo(Integer value) {
            addCriterion("ou_attr_def_mandatory <>", value, "ouAttrDefMandatory");
            return (Criteria) this;
        }

        public Criteria andOuAttrDefMandatoryGreaterThan(Integer value) {
            addCriterion("ou_attr_def_mandatory >", value, "ouAttrDefMandatory");
            return (Criteria) this;
        }

        public Criteria andOuAttrDefMandatoryGreaterThanOrEqualTo(Integer value) {
            addCriterion("ou_attr_def_mandatory >=", value, "ouAttrDefMandatory");
            return (Criteria) this;
        }

        public Criteria andOuAttrDefMandatoryLessThan(Integer value) {
            addCriterion("ou_attr_def_mandatory <", value, "ouAttrDefMandatory");
            return (Criteria) this;
        }

        public Criteria andOuAttrDefMandatoryLessThanOrEqualTo(Integer value) {
            addCriterion("ou_attr_def_mandatory <=", value, "ouAttrDefMandatory");
            return (Criteria) this;
        }

        public Criteria andOuAttrDefMandatoryIn(List<Integer> values) {
            addCriterion("ou_attr_def_mandatory in", values, "ouAttrDefMandatory");
            return (Criteria) this;
        }

        public Criteria andOuAttrDefMandatoryNotIn(List<Integer> values) {
            addCriterion("ou_attr_def_mandatory not in", values, "ouAttrDefMandatory");
            return (Criteria) this;
        }

        public Criteria andOuAttrDefMandatoryBetween(Integer value1, Integer value2) {
            addCriterion("ou_attr_def_mandatory between", value1, value2, "ouAttrDefMandatory");
            return (Criteria) this;
        }

        public Criteria andOuAttrDefMandatoryNotBetween(Integer value1, Integer value2) {
            addCriterion("ou_attr_def_mandatory not between", value1, value2, "ouAttrDefMandatory");
            return (Criteria) this;
        }

        public Criteria andOuAttrDefEditableIsNull() {
            addCriterion("ou_attr_def_editable is null");
            return (Criteria) this;
        }

        public Criteria andOuAttrDefEditableIsNotNull() {
            addCriterion("ou_attr_def_editable is not null");
            return (Criteria) this;
        }

        public Criteria andOuAttrDefEditableEqualTo(Integer value) {
            addCriterion("ou_attr_def_editable =", value, "ouAttrDefEditable");
            return (Criteria) this;
        }

        public Criteria andOuAttrDefEditableNotEqualTo(Integer value) {
            addCriterion("ou_attr_def_editable <>", value, "ouAttrDefEditable");
            return (Criteria) this;
        }

        public Criteria andOuAttrDefEditableGreaterThan(Integer value) {
            addCriterion("ou_attr_def_editable >", value, "ouAttrDefEditable");
            return (Criteria) this;
        }

        public Criteria andOuAttrDefEditableGreaterThanOrEqualTo(Integer value) {
            addCriterion("ou_attr_def_editable >=", value, "ouAttrDefEditable");
            return (Criteria) this;
        }

        public Criteria andOuAttrDefEditableLessThan(Integer value) {
            addCriterion("ou_attr_def_editable <", value, "ouAttrDefEditable");
            return (Criteria) this;
        }

        public Criteria andOuAttrDefEditableLessThanOrEqualTo(Integer value) {
            addCriterion("ou_attr_def_editable <=", value, "ouAttrDefEditable");
            return (Criteria) this;
        }

        public Criteria andOuAttrDefEditableIn(List<Integer> values) {
            addCriterion("ou_attr_def_editable in", values, "ouAttrDefEditable");
            return (Criteria) this;
        }

        public Criteria andOuAttrDefEditableNotIn(List<Integer> values) {
            addCriterion("ou_attr_def_editable not in", values, "ouAttrDefEditable");
            return (Criteria) this;
        }

        public Criteria andOuAttrDefEditableBetween(Integer value1, Integer value2) {
            addCriterion("ou_attr_def_editable between", value1, value2, "ouAttrDefEditable");
            return (Criteria) this;
        }

        public Criteria andOuAttrDefEditableNotBetween(Integer value1, Integer value2) {
            addCriterion("ou_attr_def_editable not between", value1, value2, "ouAttrDefEditable");
            return (Criteria) this;
        }

        public Criteria andOuAttrDefMaxIsNull() {
            addCriterion("ou_attr_def_max is null");
            return (Criteria) this;
        }

        public Criteria andOuAttrDefMaxIsNotNull() {
            addCriterion("ou_attr_def_max is not null");
            return (Criteria) this;
        }

        public Criteria andOuAttrDefMaxEqualTo(String value) {
            addCriterion("ou_attr_def_max =", value, "ouAttrDefMax");
            return (Criteria) this;
        }

        public Criteria andOuAttrDefMaxNotEqualTo(String value) {
            addCriterion("ou_attr_def_max <>", value, "ouAttrDefMax");
            return (Criteria) this;
        }

        public Criteria andOuAttrDefMaxGreaterThan(String value) {
            addCriterion("ou_attr_def_max >", value, "ouAttrDefMax");
            return (Criteria) this;
        }

        public Criteria andOuAttrDefMaxGreaterThanOrEqualTo(String value) {
            addCriterion("ou_attr_def_max >=", value, "ouAttrDefMax");
            return (Criteria) this;
        }

        public Criteria andOuAttrDefMaxLessThan(String value) {
            addCriterion("ou_attr_def_max <", value, "ouAttrDefMax");
            return (Criteria) this;
        }

        public Criteria andOuAttrDefMaxLessThanOrEqualTo(String value) {
            addCriterion("ou_attr_def_max <=", value, "ouAttrDefMax");
            return (Criteria) this;
        }

        public Criteria andOuAttrDefMaxLike(String value) {
            addCriterion("ou_attr_def_max like", value, "ouAttrDefMax");
            return (Criteria) this;
        }

        public Criteria andOuAttrDefMaxNotLike(String value) {
            addCriterion("ou_attr_def_max not like", value, "ouAttrDefMax");
            return (Criteria) this;
        }

        public Criteria andOuAttrDefMaxIn(List<String> values) {
            addCriterion("ou_attr_def_max in", values, "ouAttrDefMax");
            return (Criteria) this;
        }

        public Criteria andOuAttrDefMaxNotIn(List<String> values) {
            addCriterion("ou_attr_def_max not in", values, "ouAttrDefMax");
            return (Criteria) this;
        }

        public Criteria andOuAttrDefMaxBetween(String value1, String value2) {
            addCriterion("ou_attr_def_max between", value1, value2, "ouAttrDefMax");
            return (Criteria) this;
        }

        public Criteria andOuAttrDefMaxNotBetween(String value1, String value2) {
            addCriterion("ou_attr_def_max not between", value1, value2, "ouAttrDefMax");
            return (Criteria) this;
        }

        public Criteria andOuAttrDefMinIsNull() {
            addCriterion("ou_attr_def_min is null");
            return (Criteria) this;
        }

        public Criteria andOuAttrDefMinIsNotNull() {
            addCriterion("ou_attr_def_min is not null");
            return (Criteria) this;
        }

        public Criteria andOuAttrDefMinEqualTo(String value) {
            addCriterion("ou_attr_def_min =", value, "ouAttrDefMin");
            return (Criteria) this;
        }

        public Criteria andOuAttrDefMinNotEqualTo(String value) {
            addCriterion("ou_attr_def_min <>", value, "ouAttrDefMin");
            return (Criteria) this;
        }

        public Criteria andOuAttrDefMinGreaterThan(String value) {
            addCriterion("ou_attr_def_min >", value, "ouAttrDefMin");
            return (Criteria) this;
        }

        public Criteria andOuAttrDefMinGreaterThanOrEqualTo(String value) {
            addCriterion("ou_attr_def_min >=", value, "ouAttrDefMin");
            return (Criteria) this;
        }

        public Criteria andOuAttrDefMinLessThan(String value) {
            addCriterion("ou_attr_def_min <", value, "ouAttrDefMin");
            return (Criteria) this;
        }

        public Criteria andOuAttrDefMinLessThanOrEqualTo(String value) {
            addCriterion("ou_attr_def_min <=", value, "ouAttrDefMin");
            return (Criteria) this;
        }

        public Criteria andOuAttrDefMinLike(String value) {
            addCriterion("ou_attr_def_min like", value, "ouAttrDefMin");
            return (Criteria) this;
        }

        public Criteria andOuAttrDefMinNotLike(String value) {
            addCriterion("ou_attr_def_min not like", value, "ouAttrDefMin");
            return (Criteria) this;
        }

        public Criteria andOuAttrDefMinIn(List<String> values) {
            addCriterion("ou_attr_def_min in", values, "ouAttrDefMin");
            return (Criteria) this;
        }

        public Criteria andOuAttrDefMinNotIn(List<String> values) {
            addCriterion("ou_attr_def_min not in", values, "ouAttrDefMin");
            return (Criteria) this;
        }

        public Criteria andOuAttrDefMinBetween(String value1, String value2) {
            addCriterion("ou_attr_def_min between", value1, value2, "ouAttrDefMin");
            return (Criteria) this;
        }

        public Criteria andOuAttrDefMinNotBetween(String value1, String value2) {
            addCriterion("ou_attr_def_min not between", value1, value2, "ouAttrDefMin");
            return (Criteria) this;
        }

        public Criteria andOuAttrDefResUuidIsNull() {
            addCriterion("ou_attr_def_res_uuid is null");
            return (Criteria) this;
        }

        public Criteria andOuAttrDefResUuidIsNotNull() {
            addCriterion("ou_attr_def_res_uuid is not null");
            return (Criteria) this;
        }

        public Criteria andOuAttrDefResUuidEqualTo(String value) {
            addCriterion("ou_attr_def_res_uuid =", value, "ouAttrDefResUuid");
            return (Criteria) this;
        }

        public Criteria andOuAttrDefResUuidNotEqualTo(String value) {
            addCriterion("ou_attr_def_res_uuid <>", value, "ouAttrDefResUuid");
            return (Criteria) this;
        }

        public Criteria andOuAttrDefResUuidGreaterThan(String value) {
            addCriterion("ou_attr_def_res_uuid >", value, "ouAttrDefResUuid");
            return (Criteria) this;
        }

        public Criteria andOuAttrDefResUuidGreaterThanOrEqualTo(String value) {
            addCriterion("ou_attr_def_res_uuid >=", value, "ouAttrDefResUuid");
            return (Criteria) this;
        }

        public Criteria andOuAttrDefResUuidLessThan(String value) {
            addCriterion("ou_attr_def_res_uuid <", value, "ouAttrDefResUuid");
            return (Criteria) this;
        }

        public Criteria andOuAttrDefResUuidLessThanOrEqualTo(String value) {
            addCriterion("ou_attr_def_res_uuid <=", value, "ouAttrDefResUuid");
            return (Criteria) this;
        }

        public Criteria andOuAttrDefResUuidLike(String value) {
            addCriterion("ou_attr_def_res_uuid like", value, "ouAttrDefResUuid");
            return (Criteria) this;
        }

        public Criteria andOuAttrDefResUuidNotLike(String value) {
            addCriterion("ou_attr_def_res_uuid not like", value, "ouAttrDefResUuid");
            return (Criteria) this;
        }

        public Criteria andOuAttrDefResUuidIn(List<String> values) {
            addCriterion("ou_attr_def_res_uuid in", values, "ouAttrDefResUuid");
            return (Criteria) this;
        }

        public Criteria andOuAttrDefResUuidNotIn(List<String> values) {
            addCriterion("ou_attr_def_res_uuid not in", values, "ouAttrDefResUuid");
            return (Criteria) this;
        }

        public Criteria andOuAttrDefResUuidBetween(String value1, String value2) {
            addCriterion("ou_attr_def_res_uuid between", value1, value2, "ouAttrDefResUuid");
            return (Criteria) this;
        }

        public Criteria andOuAttrDefResUuidNotBetween(String value1, String value2) {
            addCriterion("ou_attr_def_res_uuid not between", value1, value2, "ouAttrDefResUuid");
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