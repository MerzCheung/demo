package com.example.demo.aspect;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.converters.AutoConverter;
import com.alibaba.fastjson.JSON;
import com.example.demo.annotation.Converter;
import com.example.demo.converter.ConverterBase;
import com.example.demo.landray.kmReviewWebserviceServiceSource.AttachmentForm;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.*;
import java.util.stream.Collectors;

@Aspect
@Component
public class ConverterAspect {

    @Around("execution(public * * (..)) && @annotation(com.example.demo.annotation.ConverterMethod)")
    public Object requiresPermissions(ProceedingJoinPoint point) throws Throwable {
        Object proceed = point.proceed();
        Set set = new HashSet<>();
        if (proceed instanceof Object) {
            Field[] declaredFields = proceed.getClass().getDeclaredFields();
            for (int i = 0 , len = declaredFields.length; i < len; i++) {
                Field declaredField = declaredFields[i];
                declaredField.setAccessible(true);
                Object o = declaredField.get(proceed);
                Converter annotation = declaredField.getAnnotation(Converter.class);
                if (annotation != null) {
                    Class<? extends ConverterBase> converter = annotation.converter();
                    ConverterBase converterBase = converter.newInstance();
                    Object converter1 = converterBase.converter((String) o);
                    declaredField.set(proceed, converter1);
                    System.out.println(converterBase.getClass());
                    set.add(converterBase);
                }
            }

            set.stream().forEach(item -> {
                Field[] declaredFields1 = item.getClass().getDeclaredFields();
                for (int i = 0 , len = declaredFields1.length; i < len; i++) {
                    Field declaredField = declaredFields1[i];
                    declaredField.setAccessible(true);
                    try {
                        declaredField.set(item, null);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        return proceed;
    }

    public static void clearStatic(Class clazz) {
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            ExcelProperty annotation = declaredField.getAnnotation(ExcelProperty.class);
            if (annotation != null) {
                Class<? extends com.alibaba.excel.converters.Converter> converter = annotation.converter();
                if (converter != AutoConverter.class) {
                    Field[] declaredFields1 = converter.getDeclaredFields();
                    for (Field declaredField2 : declaredFields1) {
                        declaredField2.setAccessible(true);
                        try {
                            declaredField2.set(converter, null);
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

//    private List<AttachmentForm> attachmentFormsConverter(ReviewBaseEntity reviewBaseEntity, List<ProcessFieldMappingEntity> fields) throws Exception {
//        Map<String, String> fieldMap = fields.stream().collect(Collectors.toMap(ProcessFieldMappingEntity::getAttribute, ProcessFieldMappingEntity::getField, (k1, k2) -> k1));
//        if (!fieldMap.isEmpty()) {
//            List<AttachmentForm> attForms = new ArrayList<AttachmentForm>();
//            Field[] declaredFields = reviewBaseEntity.getClass().getDeclaredFields();
//            for (Field declaredField : declaredFields) {
//                declaredField.setAccessible(true);
//                String name = declaredField.getName();
//                Object value = declaredField.get(reviewBaseEntity);
//                if (StringUtils.isNotBlank(fieldMap.get(name)) && value != null) {
//                    if (declaredField.getGenericType() instanceof ParameterizedType) {
//                        ParameterizedType pt = (ParameterizedType) declaredField.getGenericType();
//                        if (pt.getActualTypeArguments()[0].equals(AttachmentEntity.class)) {
//                            List<AttachmentEntity> attachmentEntities = (List<AttachmentEntity>) value;
//                            String fdKey = fieldMap.get(name);
//                            for (AttachmentEntity attachmentEntity : attachmentEntities) {
//                                AttachmentForm attachmentForm = createUrlFile(fdKey, attachmentEntity.getFileName(), attachmentEntity.getUrl());
//                                attForms.add(attachmentForm);
//                            }
//                        } else {
//                            throw new SMSException("附件类型请指定List<AttachmentEntity>");
//                        }
//                    } else {
//                        throw new SMSException("附件类型请指定List<AttachmentEntity>");
//                    }
//                }
//            }
//            return attForms;
//        }
//        return null;
//    }
//
//    private String formValuesConverter(ReviewBaseEntity reviewBaseEntity, List<ProcessFieldMappingEntity> fields) throws IllegalAccessException {
//        Map<String, String> fieldMap = fields.stream().collect(Collectors.toMap(ProcessFieldMappingEntity::getAttribute, ProcessFieldMappingEntity::getField, (k1, k2) -> k1));
//        if (!fieldMap.isEmpty()) {
//            Map map = new HashMap();
//            Field[] declaredFields = reviewBaseEntity.getClass().getDeclaredFields();
//            for (Field declaredField : declaredFields) {
//                declaredField.setAccessible(true);
//                String name = declaredField.getName();
//                Object value = declaredField.get(reviewBaseEntity);
//                if (StringUtils.isNotBlank(fieldMap.get(name)) && value != null) {
//                    map.put(fieldMap.get(name), value);
//                }
//            }
//            return JSON.toJSONString(map);
//        }
//        return null;
//    }
}
