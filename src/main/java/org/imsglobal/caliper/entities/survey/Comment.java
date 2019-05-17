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

package org.imsglobal.caliper.entities.survey;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.imsglobal.caliper.entities.*;
import org.imsglobal.caliper.entities.agent.Person;

import javax.annotation.Nullable;

public class Comment extends AbstractEntity implements CaliperGeneratable {

    @JsonProperty("commenter")
    private final Person commenter;

    @JsonProperty("commentedOn")
    private final CaliperEntity commentedOn;

    @JsonProperty("value")
    private final String value;

    /**
     * @param builder apply builder object properties to the object.
     */
    protected Comment(Builder<?> builder) {
        super(builder);
        this.commenter = builder.commenter;
        this.commentedOn = builder.commentedOn;
        this.value = builder.value;
    }

    /**
     * @return the commenter
     */
    @Nullable
    public Person getCommenter() { return commenter; }

    /**
     * @return the commentedOn entity
     */
    @Nullable
    public CaliperEntity getCommentedOn() { return commentedOn; }

    /**
     * @return the value
     */
    @Nullable
    public String getValue() { return value; }

    /**
     * Builder class provides a fluid interface for setting object properties.
     * @param <T> builder.
     */
    public static abstract class Builder<T extends Builder<T>> extends AbstractEntity.Builder<T> {
        private Person commenter;
        private CaliperEntity commentedOn;
        private String value;

        /**
         * Constructor
         */
        public Builder() {
            super.type(EntityType.COMMENT);
        }

        /**
         * @param commenter
         * @return builder.
         */
        public T commenter(Person commenter) {
            this.commenter = commenter;
            return self();
        }

        /**
         * @param commentedOn
         * @return builder.
         */
        public T commentedOn(CaliperEntity commentedOn) {
            this.commentedOn = commentedOn;
            return self();
        }

        /**
         * @param value
         * @return builder.
         */
        public T value(String value) {
            this.value = value;
            return self();
        }

        /**
         * Client invokes build method in order to create an immutable object.
         * @return a new instance of the Comment.
         */
        public Comment build() {
            return new Comment(this);
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
     * @return a new instance of the builder.
     */
    public static Builder<?> builder() {
        return new Builder2();
    }
}