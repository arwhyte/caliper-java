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

package org.imsglobal.caliper.events;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.imsglobal.caliper.TestUtils;
import org.imsglobal.caliper.actions.Action;
import org.imsglobal.caliper.context.JsonldContext;
import org.imsglobal.caliper.context.JsonldStringContext;
import org.imsglobal.caliper.entities.agent.CourseSection;
import org.imsglobal.caliper.entities.agent.Membership;
import org.imsglobal.caliper.entities.agent.Person;
import org.imsglobal.caliper.entities.agent.Role;
import org.imsglobal.caliper.entities.agent.SoftwareApplication;
import org.imsglobal.caliper.entities.agent.Status;
import org.imsglobal.caliper.entities.session.Session;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;

import static com.yammer.dropwizard.testing.JsonHelpers.jsonFixture;

@Category(org.imsglobal.caliper.UnitTest.class)
public class ToolLaunchEventLaunchedTest {
    private JsonldContext context;
    private String id;
    private Person actor;
    private SoftwareApplication object, edApp;
    private CourseSection group;
    private Membership membership;
    private Session session;
    private ToolLaunchEvent event;

    private static final String BASE_COM_IRI = "https://example.com";
    private static final String BASE_EDU_IRI = "https://example.edu";

    @Before
    public void setUp() throws Exception {
        context = JsonldStringContext.getDefault();

        id = "urn:uuid:a2e8b214-4d4a-4456-bb4c-099945749117";

        actor = Person.builder().id(BASE_EDU_IRI.concat("/users/554433")).build();

        object = SoftwareApplication.builder().id(BASE_COM_IRI.concat("/lti/tool")).build();

        edApp = SoftwareApplication.builder().id(BASE_EDU_IRI).build();

        group = CourseSection.builder()
            .id(BASE_EDU_IRI.concat("/terms/201801/courses/7/sections/1"))
            .courseNumber("CPS 435-01")
            .academicSession("Fall 2018")
            .build();

        membership = Membership.builder()
            .id(BASE_EDU_IRI.concat("/terms/201801/courses/7/sections/1/rosters/1"))
            .member(Person.builder().id(actor.getId()).coercedToId(true).build())
            .organization(CourseSection.builder().id(group.getId()).coercedToId(true).build())
            .status(Status.ACTIVE)
            .role(Role.LEARNER)
            .dateCreated(new DateTime(2018, 8, 1, 6, 0, 0, 0, DateTimeZone.UTC))
            .build();

        session = Session.builder()
            .id(BASE_EDU_IRI.concat("/sessions/1f6442a482de72ea6ad134943812bff564a76259"))
            .startedAtTime(new DateTime(2018, 11, 15, 10, 0, 0, 0, DateTimeZone.UTC))
            .build();

        // Build event
        event = buildEvent(Action.LAUNCHED);
    }

    @Test
    public void caliperEventSerializesToJSON() throws Exception {
        ObjectMapper mapper = TestUtils.createCaliperObjectMapper();
        String json = mapper.writeValueAsString(event);

        String fixture = jsonFixture("fixtures/caliperEventToolLaunchLaunched.json");
        JSONAssert.assertEquals(fixture, json, JSONCompareMode.NON_EXTENSIBLE);
    }

    @Test(expected=IllegalArgumentException.class)
    public void viewEventRejectsNavigatedToAction() {
        buildEvent(Action.NAVIGATED_TO);
    }

    @After
    public void teardown() {
        event = null;
    }

    /**
     * Build View event
     * @param action
     * @return event
     */
    private ToolLaunchEvent buildEvent(Action action) {
        return ToolLaunchEvent.builder()
            .context(context)
            .id(id)
            .actor(actor)
            .action(action)
            .object(object)
            .eventTime(new DateTime(2018, 11, 15, 10, 15, 0, 0, DateTimeZone.UTC))
            .edApp(edApp)
            .group(group)
            .membership(membership)
            .session(session)
            .build();
    }
}