<#-- // Fields -->

<#foreach field in pojo.getAllPropertiesIterator()><#if pojo.getMetaAttribAsBool(field, "gen-property", true)> <#if pojo.hasMetaAttribute(field, "field-description")>    /**
     ${pojo.getFieldJavaDoc(field, 0)}
     */
 </#if><#if pojo.hasIdentifierProperty()>
<#if field.equals(clazz.identifierProperty)>
${pojo.generateAnnIdGenerator()}</#if></#if><#if c2h.isOneToOne(field)>
${pojo.generateOneToOneAnnotation(field, md)}
<#elseif c2h.isManyToOne(field)>
${pojo.generateManyToOneAnnotation(field)}
<#--TODO support optional and targetEntity-->
${pojo.generateJoinColumnsAnnotation(field, md)}
<#elseif c2h.isCollection(field)>
${pojo.generateCollectionAnnotation(field, md)}
<#else>
${pojo.generateBasicAnnotation(field)}
${pojo.generateAnnColumnAnnotation(field)}
</#if>
    ${pojo.getFieldModifiers(field)} ${pojo.getJavaTypeName(field, jdk5)} ${c2j.keyWordCheck(field.name)}<#if pojo.hasFieldInitializor(field, jdk5)> = ${pojo.getFieldInitialization(field, jdk5)}</#if>;
</#if>
</#foreach>
