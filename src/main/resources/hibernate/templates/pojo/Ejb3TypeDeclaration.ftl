<#if ejb3?if_exists>
<#if pojo.isComponent()>
@${pojo.importType("javax.persistence.Embeddable")}
<#else>
@${pojo.importType("javax.persistence.Entity")}
@${pojo.importType("javax.persistence.Table")}(name="${clazz.table.name}"
<#if clazz.table.schema?exists>
    ,schema="${clazz.table.schema}"
</#if><#if clazz.table.catalog?exists>
    ,catalog="${clazz.table.catalog}"
</#if>
<#assign uniqueConstraint=pojo.generateAnnTableUniqueConstraint()>
<#if uniqueConstraint?has_content>
    , uniqueConstraints = ${uniqueConstraint} 
</#if>)
</#if>
</#if>
@${pojo.importType("org.hibernate.annotations.FilterDef")}(
    name = "ACCOUNT_FILTER",
    parameters = @${pojo.importType("org.hibernate.annotations.ParamDef")}( name="userName", type="string" ))
@${pojo.importType("org.hibernate.annotations.Filter")}(name = "ACCOUNT_FILTER", condition = "account_id=(select sec99.account_id from user sec99 where sec99.user_name = :userName)")
