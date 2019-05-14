<#if pojo.getJavaTypeName(property, jdk5) == "String">
    @${pojo.importType("javax.validation.constraints.Size")}(min=0,max=${property.value.columnIterator.next().length?c})</#if><#if !property.optional && !property.equals(clazz.identifierProperty)>
    @${pojo.importType("javax.validation.constraints.NotNull")}</#if><#if property.name.startsWith("modifiedDate")>
    @${pojo.importType("org.springframework.data.annotation.LastModifiedDate")}</#if><#if property.name.startsWith("createdDate")>
    @${pojo.importType("org.springframework.data.annotation.CreatedDate")}</#if><#if property.name.startsWith("createdBy")>
    @${pojo.importType("org.springframework.data.annotation.CreatedBy")}</#if><#if property.name.startsWith("modifiedBy")>
    @${pojo.importType("org.springframework.data.annotation.LastModifiedBy")}</#if>
