/**
 * This file is part of IMS Caliper Analytics™ and is licensed to
 * IMS Global Learning Consortium, Inc. (http://www.imsglobal.org)
 * under one or more contributor license agreements.  See the NOTICE
 * file distributed with this work for additional information.
 *
 * IMS Caliper is free software: you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation, version 3 of the License.
 *
 * IMS Caliper is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR
 * A PARTICULAR PURPOSE.  See the GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License along
 * with this program. If not, see <http://www.gnu.org/licenses/>.
 */

package org.imsglobal.caliper.entities.resource;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import org.imsglobal.caliper.entities.Collection;
import org.imsglobal.caliper.entities.EntityType;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;

public class DigitalResourceCollection extends DigitalResource implements Collection<Resource> {

    @JsonProperty("@type")
    private final String type;

    @JsonProperty("items")
    private final ImmutableList<Resource> items;

    /**
     * @param builder apply builder object properties to the object.
     */
    protected DigitalResourceCollection(Builder<?> builder) {
        super(builder);
        this.type = builder.type;
        this.items = ImmutableList.copyOf(builder.items);
    }

    /**
     * @return the type
     */
    @Override
    @Nonnull
    public String getType() {
        return type;
    }

    /**
     * Return an immutable list of the Collection's items.
     * @return the items
     */
    @Override
    @Nullable
    public ImmutableList<Resource> getItems() {
        return items;
    }

    /**
     * Builder class provides a fluid interface for setting object properties.
     * @param <T> builder
     */
    public static abstract class Builder<T extends Builder<T>> extends DigitalResource.Builder<T>  {
        private String type;
        private List<Resource> items = Lists.newArrayList();

        /**
         * Initialize type with default value.
         */
        public Builder() {
            type(EntityType.DIGITAL_RESOURCE_COLLECTION.getValue());
        }

        /**
         * @param type
         * @return builder.
         */
        private T type(String type) {
            this.type = type;
            return self();
        }

        /**
         * @param items
         * @return builder.
         */
        public T items(List<Resource> items) {
            this.items = items;
            return self();
        }

        /**
         * @param item
         * @return builder.
         */
        public T item(Resource item) {
            this.items.add(item);
            return self();
        }

        /**
         * Client invokes build method in order to create an immutable object.
         * @return a new DigitalResourceCollection instance.
         */
        public DigitalResourceCollection build() {
            return new DigitalResourceCollection(this);
        }
    }

    /**
     *
     */
    private static class Builder2 extends Builder<Builder2> {
        @Override
        protected Builder2 self() {
            return this;
        }
    }

    /**
     * Static factory method.
     * @return a new Builder instance.
     */
    public static Builder<?> builder() {
        return new Builder2();
    }
}