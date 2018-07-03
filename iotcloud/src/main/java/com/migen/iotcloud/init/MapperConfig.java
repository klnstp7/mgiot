package com.migen.iotcloud.init;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.cglib.beans.BeanCopier;

import java.text.ParseException;


/**
 * 数据实体与DTO转换关系类
 * Created by Administrator on 2017/2/6.
 */
public class MapperConfig {
    static ModelMapper modelMapper = new ModelMapper();

    public static void CreateMapping() {
    }

    /**
     * 实体转DTO,使用Copy方式
     *
     * @param source          源实体
     * @param destinationType 目标实体类型
     * @param <T>
     * @return
     */
    public static <T> T map(Object source, Class<T> destinationType) {
        return modelMapper.map(source, destinationType);
    }

    /**
     * DTO实体转DTO
     *
     * @param source          源实体
     * @param  sourceType 源数据类型
     * @param targetType 目标实体类型
     * @param <T>
     * @return
     */
    public static <T, E> E copy(Object source, Class<T> sourceType, Class<E> targetType) {
        E targetDto = null;
        try {
            Class<?> cls = Class.forName(sourceType.getName());
            T sourceDto = (T) cls.newInstance();
            cls = Class.forName(targetType.getName());
            targetDto = (E) cls.newInstance();
            BeanCopier beanCopier = BeanCopier.create(sourceDto.getClass(), targetDto.getClass(), false);
            beanCopier.copy(source, targetDto, null);
            return targetDto;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return targetDto;
    }
}
