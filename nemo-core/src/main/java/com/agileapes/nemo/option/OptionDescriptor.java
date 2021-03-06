package com.agileapes.nemo.option;

import com.agileapes.nemo.error.OptionDefinitionException;

import java.util.Properties;

/**
 * This class encapsulates the definition of an option as seen by the framework, through what the action
 * developer has made available.
 *
 * @author Mohammad Milad Naseri (m.m.naseri@gmail.com)
 * @since 1.0 (2013/6/10, 17:20)
 */
public class OptionDescriptor {

    private final String name;
    private final Character alias;
    private final Integer index;
    private final boolean required;
    private final Class<?> type;
    private final Object defaultValue;
    private final Properties properties;

    public OptionDescriptor(String name, Character alias, Integer index, boolean required, Class<?> type, Object defaultValue, Properties properties) throws OptionDefinitionException {
        this.properties = properties;
        if (name == null) {
            throw new OptionDefinitionException("Option name cannot be null");
        }
        this.name = name;
        this.alias = alias;
        this.index = index;
        this.required = required;
        this.type = type;
        this.defaultValue = defaultValue;
    }

    public String getName() {
        return name;
    }

    public Character getAlias() {
        return alias;
    }

    public Integer getIndex() {
        return index;
    }

    public boolean isRequired() {
        return required;
    }

    public Class<?> getType() {
        return type;
    }

    public Object getDefaultValue() {
        return defaultValue;
    }

    public boolean hasAlias() {
        return alias != null;
    }

    public boolean hasIndex() {
        return index != null;
    }

    public boolean isFlag() {
        return Boolean.class.equals(getType()) || boolean.class.equals(getType());
    }

    public Properties getMetadata() {
        return properties;
    }

    @Override
    public String toString() {
        return (!required ? "[" : "") + "--" + name + (alias != null ? "|" + alias : "") + (!required ? "]" : "");
    }

}
