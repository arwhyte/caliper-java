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

package org.imsglobal.caliper.lti;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LisClaim {
    @JsonProperty("person_sourcedid")
    private String personSourcedId;
    @JsonProperty("course_offering_sourcedid")
    private String courseOfferingSourcedId;
    @JsonProperty("course_section_sourcedid")
    private String courseSectionSourcedId;

    /**
     * Constructor
     * @param builder
     */
    private LisClaim(Builder builder) {
        this.personSourcedId = builder.personSourcedId;
        this.courseOfferingSourcedId = builder.courseOfferingSourcedId;
        this.courseSectionSourcedId = builder.courseSectionSourcedId;
    }

    /**
     * Builder
     */
    public static class Builder {
        private String personSourcedId;
        private String courseOfferingSourcedId;
        private String courseSectionSourcedId;

        public Builder personSourcedId(String personSourcedId) {
            this.personSourcedId = personSourcedId;
            return this;
        }

        public Builder courseOfferingSourcedId(String courseOfferingSourcedId) {
            this.courseOfferingSourcedId = courseOfferingSourcedId;
            return this;
        }

        public Builder courseSectionSourcedId(String courseSectionSourcedId) {
            this.courseSectionSourcedId = courseSectionSourcedId;
            return this;
        }

        public LisClaim build() {
            return new LisClaim(this);
        }
    }

    /**
     * Factory method
     * @return builder
     */
    public static Builder builder() {
        return new Builder();
    }
}