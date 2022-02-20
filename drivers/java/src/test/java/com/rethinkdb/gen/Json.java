// Autogenerated by convert_tests.py and process_polyglot.py.
// Do not edit this file directly.
// The template for this file is located at:
// ../../../../../../../templates/Test.java
package com.rethinkdb.gen;

import com.rethinkdb.RethinkDB;
import com.rethinkdb.gen.exc.*;
import com.rethinkdb.gen.ast.*;
import com.rethinkdb.ast.ReqlAst;
import com.rethinkdb.model.MapObject;
import com.rethinkdb.model.OptArgs;
import com.rethinkdb.net.Connection;
import com.rethinkdb.net.Cursor;
import junit.framework.TestCase;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.junit.*;
import org.junit.rules.ExpectedException;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.Instant;
import java.util.stream.LongStream;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.concurrent.TimeoutException;
import java.util.regex.Pattern;
import java.util.Collections;
import java.nio.charset.StandardCharsets;

import static com.rethinkdb.TestingCommon.*;
import com.rethinkdb.TestingFramework;

public class Json {
    // Tests RQL json parsing
    Logger logger = LoggerFactory.getLogger(Json.class);
    public static final RethinkDB r = RethinkDB.r;

    Connection conn;

    @Before
    public void setUp() throws Exception {
        logger.info("Setting up.");
        conn = TestingFramework.createConnection();
        try {
            r.dbCreate("test").run(conn);
            r.db("test").wait_().run(conn);
        }catch (Exception e){}
    }

    @After
    public void tearDown() throws Exception {
        logger.info("Tearing down.");
        r.db("rethinkdb").table("_debug_scratch").delete().run(conn);
        if(!conn.isOpen()){
            conn.close();
            conn = TestingFramework.createConnection();
        }
        r.dbDrop("test").run(conn);
        conn.close(false);
    }

    // Matches Python's str() function, which we use.
    // TODO: We might want to handle this in a visit_Call in convert_tests.py instead.
    private static String str(long i) {
        return String.valueOf(i);
    }

    // A hack to concatenate two List<Long>s -- see is_array_add in convert_tests.py.
    private static List<Long> concatLong(List<Long> x, List<Long> y) {
        List<Long> ret = new ArrayList<Long>(x);
        ret.addAll(y);
        return ret;
    }

    // Autogenerated tests below

    @Test(timeout=120000)
    public void test() throws Exception {

        {
            // json.yaml line #4
            /* [1,2,3] */
            List expected_ = r.array(1L, 2L, 3L);
            /* r.json("[1,2,3]") */
            logger.info("About to run line #4: r.json('[1,2,3]')");
            Object obtained = runOrCatch(r.json("[1,2,3]"),
                                          new OptArgs()
                                          ,conn);
            try {
                assertEquals(expected_, obtained);
            logger.info("Finished running line #4");
            } catch (Throwable ae) {
                logger.error("Whoops, got exception on line #4:" + ae.toString());
                if(obtained instanceof Throwable) {
                    ae.addSuppressed((Throwable) obtained);
                }
                throw ae;
            }
        }

        {
            // json.yaml line #7
            /* 1 */
            Long expected_ = 1L;
            /* r.json("1") */
            logger.info("About to run line #7: r.json('1')");
            Object obtained = runOrCatch(r.json("1"),
                                          new OptArgs()
                                          ,conn);
            try {
                assertEquals(expected_, obtained);
            logger.info("Finished running line #7");
            } catch (Throwable ae) {
                logger.error("Whoops, got exception on line #7:" + ae.toString());
                if(obtained instanceof Throwable) {
                    ae.addSuppressed((Throwable) obtained);
                }
                throw ae;
            }
        }

        {
            // json.yaml line #10
            /* {} */
            Map expected_ = r.hashMap();
            /* r.json("{}") */
            logger.info("About to run line #10: r.json('{}')");
            Object obtained = runOrCatch(r.json("{}"),
                                          new OptArgs()
                                          ,conn);
            try {
                assertEquals(expected_, obtained);
            logger.info("Finished running line #10");
            } catch (Throwable ae) {
                logger.error("Whoops, got exception on line #10:" + ae.toString());
                if(obtained instanceof Throwable) {
                    ae.addSuppressed((Throwable) obtained);
                }
                throw ae;
            }
        }

        {
            // json.yaml line #13
            /* "foo" */
            String expected_ = "foo";
            /* r.json('"foo"') */
            logger.info("About to run line #13: r.json('\\'foo\\'')");
            Object obtained = runOrCatch(r.json("\"foo\""),
                                          new OptArgs()
                                          ,conn);
            try {
                assertEquals(expected_, obtained);
            logger.info("Finished running line #13");
            } catch (Throwable ae) {
                logger.error("Whoops, got exception on line #13:" + ae.toString());
                if(obtained instanceof Throwable) {
                    ae.addSuppressed((Throwable) obtained);
                }
                throw ae;
            }
        }

        {
            // json.yaml line #16
            /* err("ReqlQueryLogicError", 'Failed to parse "[1,2" as JSON:' + ' Missing a comma or \']\' after an array element.', [0]) */
            Err expected_ = err("ReqlQueryLogicError", "Failed to parse \"[1,2\" as JSON:" + " Missing a comma or ']' after an array element.", r.array(0L));
            /* r.json("[1,2") */
            logger.info("About to run line #16: r.json('[1,2')");
            Object obtained = runOrCatch(r.json("[1,2"),
                                          new OptArgs()
                                          ,conn);
            try {
                assertEquals(expected_, obtained);
            logger.info("Finished running line #16");
            } catch (Throwable ae) {
                logger.error("Whoops, got exception on line #16:" + ae.toString());
                if(obtained instanceof Throwable) {
                    ae.addSuppressed((Throwable) obtained);
                }
                throw ae;
            }
        }

        {
            // json.yaml line #19
            /* '[1,2,3]' */
            String expected_ = "[1,2,3]";
            /* r.json("[1,2,3]").to_json_string() */
            logger.info("About to run line #19: r.json('[1,2,3]').toJsonString()");
            Object obtained = runOrCatch(r.json("[1,2,3]").toJsonString(),
                                          new OptArgs()
                                          ,conn);
            try {
                assertEquals(expected_, obtained);
            logger.info("Finished running line #19");
            } catch (Throwable ae) {
                logger.error("Whoops, got exception on line #19:" + ae.toString());
                if(obtained instanceof Throwable) {
                    ae.addSuppressed((Throwable) obtained);
                }
                throw ae;
            }
        }

        {
            // json.yaml line #23
            /* '[1,2,3]' */
            String expected_ = "[1,2,3]";
            /* r.json("[1,2,3]").to_json() */
            logger.info("About to run line #23: r.json('[1,2,3]').toJson()");
            Object obtained = runOrCatch(r.json("[1,2,3]").toJson(),
                                          new OptArgs()
                                          ,conn);
            try {
                assertEquals(expected_, obtained);
            logger.info("Finished running line #23");
            } catch (Throwable ae) {
                logger.error("Whoops, got exception on line #23:" + ae.toString());
                if(obtained instanceof Throwable) {
                    ae.addSuppressed((Throwable) obtained);
                }
                throw ae;
            }
        }

        {
            // json.yaml line #26
            /* '{"foo":4}' */
            String expected_ = "{\"foo\":4}";
            /* r.json("{\"foo\":4}").to_json_string() */
            logger.info("About to run line #26: r.json('{\\'foo\\':4}').toJsonString()");
            Object obtained = runOrCatch(r.json("{\"foo\":4}").toJsonString(),
                                          new OptArgs()
                                          ,conn);
            try {
                assertEquals(expected_, obtained);
            logger.info("Finished running line #26");
            } catch (Throwable ae) {
                logger.error("Whoops, got exception on line #26:" + ae.toString());
                if(obtained instanceof Throwable) {
                    ae.addSuppressed((Throwable) obtained);
                }
                throw ae;
            }
        }

        {
            // json.yaml line #30
            /* '{"foo":4}' */
            String expected_ = "{\"foo\":4}";
            /* r.json("{\"foo\":4}").to_json() */
            logger.info("About to run line #30: r.json('{\\'foo\\':4}').toJson()");
            Object obtained = runOrCatch(r.json("{\"foo\":4}").toJson(),
                                          new OptArgs()
                                          ,conn);
            try {
                assertEquals(expected_, obtained);
            logger.info("Finished running line #30");
            } catch (Throwable ae) {
                logger.error("Whoops, got exception on line #30:" + ae.toString());
                if(obtained instanceof Throwable) {
                    ae.addSuppressed((Throwable) obtained);
                }
                throw ae;
            }
        }

        // json.yaml line #34
        // text = '[{"id":1,"first_name":"Harry","last_name":"Riley","email":"hriley0@usgs.gov","country":"Andorra","ip_address":"221.25.65.136"},{"id":2,"first_name":"Bonnie","last_name":"Anderson","email":"banderson1@list-manage.com","country":"Tuvalu","ip_address":"116.162.43.150"},{"id":3,"first_name":"Marie","last_name":"Schmidt","email":"mschmidt2@diigo.com","country":"Iraq","ip_address":"181.105.59.57"},{"id":4,"first_name":"Phillip","last_name":"Willis","email":"pwillis3@com.com","country":"Montenegro","ip_address":"24.223.139.156"}]'
        logger.info("Possibly executing: String text = (String) ('[{\\'id\\':1,\\'first_name\\':\\'Harry\\',\\'last_name\\':\\'Riley\\',\\'email\\':\\'hriley0@usgs.gov\\',\\'country\\':\\'Andorra\\',\\'ip_address\\':\\'221.25.65.136\\'},{\\'id\\':2,\\'first_name\\':\\'Bonnie\\',\\'last_name\\':\\'Anderson\\',\\'email\\':\\'banderson1@list-manage.com\\',\\'country\\':\\'Tuvalu\\',\\'ip_address\\':\\'116.162.43.150\\'},{\\'id\\':3,\\'first_name\\':\\'Marie\\',\\'last_name\\':\\'Schmidt\\',\\'email\\':\\'mschmidt2@diigo.com\\',\\'country\\':\\'Iraq\\',\\'ip_address\\':\\'181.105.59.57\\'},{\\'id\\':4,\\'first_name\\':\\'Phillip\\',\\'last_name\\':\\'Willis\\',\\'email\\':\\'pwillis3@com.com\\',\\'country\\':\\'Montenegro\\',\\'ip_address\\':\\'24.223.139.156\\'}]');");
        String text = (String) ("[{\"id\":1,\"first_name\":\"Harry\",\"last_name\":\"Riley\",\"email\":\"hriley0@usgs.gov\",\"country\":\"Andorra\",\"ip_address\":\"221.25.65.136\"},{\"id\":2,\"first_name\":\"Bonnie\",\"last_name\":\"Anderson\",\"email\":\"banderson1@list-manage.com\",\"country\":\"Tuvalu\",\"ip_address\":\"116.162.43.150\"},{\"id\":3,\"first_name\":\"Marie\",\"last_name\":\"Schmidt\",\"email\":\"mschmidt2@diigo.com\",\"country\":\"Iraq\",\"ip_address\":\"181.105.59.57\"},{\"id\":4,\"first_name\":\"Phillip\",\"last_name\":\"Willis\",\"email\":\"pwillis3@com.com\",\"country\":\"Montenegro\",\"ip_address\":\"24.223.139.156\"}]");

        // json.yaml line #35
        // sorted = '[{"country":"Andorra","email":"hriley0@usgs.gov","first_name":"Harry","id":1,"ip_address":"221.25.65.136","last_name":"Riley"},{"country":"Tuvalu","email":"banderson1@list-manage.com","first_name":"Bonnie","id":2,"ip_address":"116.162.43.150","last_name":"Anderson"},{"country":"Iraq","email":"mschmidt2@diigo.com","first_name":"Marie","id":3,"ip_address":"181.105.59.57","last_name":"Schmidt"},{"country":"Montenegro","email":"pwillis3@com.com","first_name":"Phillip","id":4,"ip_address":"24.223.139.156","last_name":"Willis"}]'
        logger.info("Possibly executing: String sorted = (String) ('[{\\'country\\':\\'Andorra\\',\\'email\\':\\'hriley0@usgs.gov\\',\\'first_name\\':\\'Harry\\',\\'id\\':1,\\'ip_address\\':\\'221.25.65.136\\',\\'last_name\\':\\'Riley\\'},{\\'country\\':\\'Tuvalu\\',\\'email\\':\\'banderson1@list-manage.com\\',\\'first_name\\':\\'Bonnie\\',\\'id\\':2,\\'ip_address\\':\\'116.162.43.150\\',\\'last_name\\':\\'Anderson\\'},{\\'country\\':\\'Iraq\\',\\'email\\':\\'mschmidt2@diigo.com\\',\\'first_name\\':\\'Marie\\',\\'id\\':3,\\'ip_address\\':\\'181.105.59.57\\',\\'last_name\\':\\'Schmidt\\'},{\\'country\\':\\'Montenegro\\',\\'email\\':\\'pwillis3@com.com\\',\\'first_name\\':\\'Phillip\\',\\'id\\':4,\\'ip_address\\':\\'24.223.139.156\\',\\'last_name\\':\\'Willis\\'}]');");
        String sorted = (String) ("[{\"country\":\"Andorra\",\"email\":\"hriley0@usgs.gov\",\"first_name\":\"Harry\",\"id\":1,\"ip_address\":\"221.25.65.136\",\"last_name\":\"Riley\"},{\"country\":\"Tuvalu\",\"email\":\"banderson1@list-manage.com\",\"first_name\":\"Bonnie\",\"id\":2,\"ip_address\":\"116.162.43.150\",\"last_name\":\"Anderson\"},{\"country\":\"Iraq\",\"email\":\"mschmidt2@diigo.com\",\"first_name\":\"Marie\",\"id\":3,\"ip_address\":\"181.105.59.57\",\"last_name\":\"Schmidt\"},{\"country\":\"Montenegro\",\"email\":\"pwillis3@com.com\",\"first_name\":\"Phillip\",\"id\":4,\"ip_address\":\"24.223.139.156\",\"last_name\":\"Willis\"}]");

        {
            // json.yaml line #37
            /* sorted */
            String expected_ = sorted;
            /* r.json(text).to_json_string() */
            logger.info("About to run line #37: r.json(text).toJsonString()");
            Object obtained = runOrCatch(r.json(text).toJsonString(),
                                          new OptArgs()
                                          ,conn);
            try {
                assertEquals(expected_, obtained);
            logger.info("Finished running line #37");
            } catch (Throwable ae) {
                logger.error("Whoops, got exception on line #37:" + ae.toString());
                if(obtained instanceof Throwable) {
                    ae.addSuppressed((Throwable) obtained);
                }
                throw ae;
            }
        }

        {
            // json.yaml line #40
            /* err('ReqlQueryLogicError', 'Cannot convert `r.minval` to JSON.') */
            Err expected_ = err("ReqlQueryLogicError", "Cannot convert `r.minval` to JSON.");
            /* r.expr(r.minval).to_json_string() */
            logger.info("About to run line #40: r.expr(r.minval()).toJsonString()");
            Object obtained = runOrCatch(r.expr(r.minval()).toJsonString(),
                                          new OptArgs()
                                          ,conn);
            try {
                assertEquals(expected_, obtained);
            logger.info("Finished running line #40");
            } catch (Throwable ae) {
                logger.error("Whoops, got exception on line #40:" + ae.toString());
                if(obtained instanceof Throwable) {
                    ae.addSuppressed((Throwable) obtained);
                }
                throw ae;
            }
        }

        {
            // json.yaml line #43
            /* err('ReqlQueryLogicError', 'Cannot convert `r.maxval` to JSON.') */
            Err expected_ = err("ReqlQueryLogicError", "Cannot convert `r.maxval` to JSON.");
            /* r.expr(r.maxval).to_json_string() */
            logger.info("About to run line #43: r.expr(r.maxval()).toJsonString()");
            Object obtained = runOrCatch(r.expr(r.maxval()).toJsonString(),
                                          new OptArgs()
                                          ,conn);
            try {
                assertEquals(expected_, obtained);
            logger.info("Finished running line #43");
            } catch (Throwable ae) {
                logger.error("Whoops, got exception on line #43:" + ae.toString());
                if(obtained instanceof Throwable) {
                    ae.addSuppressed((Throwable) obtained);
                }
                throw ae;
            }
        }

        {
            // json.yaml line #46
            /* err('ReqlQueryLogicError', 'Cannot convert `r.minval` to JSON.') */
            Err expected_ = err("ReqlQueryLogicError", "Cannot convert `r.minval` to JSON.");
            /* r.expr(r.minval).coerce_to('string') */
            logger.info("About to run line #46: r.expr(r.minval()).coerceTo('string')");
            Object obtained = runOrCatch(r.expr(r.minval()).coerceTo("string"),
                                          new OptArgs()
                                          ,conn);
            try {
                assertEquals(expected_, obtained);
            logger.info("Finished running line #46");
            } catch (Throwable ae) {
                logger.error("Whoops, got exception on line #46:" + ae.toString());
                if(obtained instanceof Throwable) {
                    ae.addSuppressed((Throwable) obtained);
                }
                throw ae;
            }
        }

        {
            // json.yaml line #49
            /* err('ReqlQueryLogicError', 'Cannot convert `r.maxval` to JSON.') */
            Err expected_ = err("ReqlQueryLogicError", "Cannot convert `r.maxval` to JSON.");
            /* r.expr(r.maxval).coerce_to('string') */
            logger.info("About to run line #49: r.expr(r.maxval()).coerceTo('string')");
            Object obtained = runOrCatch(r.expr(r.maxval()).coerceTo("string"),
                                          new OptArgs()
                                          ,conn);
            try {
                assertEquals(expected_, obtained);
            logger.info("Finished running line #49");
            } catch (Throwable ae) {
                logger.error("Whoops, got exception on line #49:" + ae.toString());
                if(obtained instanceof Throwable) {
                    ae.addSuppressed((Throwable) obtained);
                }
                throw ae;
            }
        }

        {
            // json.yaml line #52
            /* {'timezone':'+00:00','$reql_type$':'TIME','epoch_time':1410393600} */
            Map expected_ = r.hashMap("timezone", "+00:00").with("$reql_type$", "TIME").with("epoch_time", 1410393600L);
            /* r.time(2014,9,11, 'Z') */
            logger.info("About to run line #52: r.time(2014L, 9L, 11L, 'Z')");
            Object obtained = runOrCatch(r.time(2014L, 9L, 11L, "Z"),
                                          new OptArgs()
                                          .with("time_format", "raw")
                                          ,conn);
            try {
                assertEquals(expected_, obtained);
            logger.info("Finished running line #52");
            } catch (Throwable ae) {
                logger.error("Whoops, got exception on line #52:" + ae.toString());
                if(obtained instanceof Throwable) {
                    ae.addSuppressed((Throwable) obtained);
                }
                throw ae;
            }
        }

        {
            // json.yaml line #57
            /* '{"$reql_type$":"TIME","epoch_time":1410393600,"timezone":"+00:00"}' */
            String expected_ = "{\"$reql_type$\":\"TIME\",\"epoch_time\":1410393600,\"timezone\":\"+00:00\"}";
            /* r.time(2014,9,11, 'Z').to_json_string() */
            logger.info("About to run line #57: r.time(2014L, 9L, 11L, 'Z').toJsonString()");
            Object obtained = runOrCatch(r.time(2014L, 9L, 11L, "Z").toJsonString(),
                                          new OptArgs()
                                          ,conn);
            try {
                assertEquals(expected_, obtained);
            logger.info("Finished running line #57");
            } catch (Throwable ae) {
                logger.error("Whoops, got exception on line #57:" + ae.toString());
                if(obtained instanceof Throwable) {
                    ae.addSuppressed((Throwable) obtained);
                }
                throw ae;
            }
        }

        {
            // json.yaml line #60
            /* {'$reql_type$':'GEOMETRY','coordinates':[0,0],'type':'Point'} */
            Map expected_ = r.hashMap("$reql_type$", "GEOMETRY").with("coordinates", r.array(0L, 0L)).with("type", "Point");
            /* r.point(0,0) */
            logger.info("About to run line #60: r.point(0L, 0L)");
            Object obtained = runOrCatch(r.point(0L, 0L),
                                          new OptArgs()
                                          ,conn);
            try {
                assertEquals(expected_, obtained);
            logger.info("Finished running line #60");
            } catch (Throwable ae) {
                logger.error("Whoops, got exception on line #60:" + ae.toString());
                if(obtained instanceof Throwable) {
                    ae.addSuppressed((Throwable) obtained);
                }
                throw ae;
            }
        }

        {
            // json.yaml line #63
            /* '{"$reql_type$":"GEOMETRY","coordinates":[0,0],"type":"Point"}' */
            String expected_ = "{\"$reql_type$\":\"GEOMETRY\",\"coordinates\":[0,0],\"type\":\"Point\"}";
            /* r.point(0,0).to_json_string() */
            logger.info("About to run line #63: r.point(0L, 0L).toJsonString()");
            Object obtained = runOrCatch(r.point(0L, 0L).toJsonString(),
                                          new OptArgs()
                                          ,conn);
            try {
                assertEquals(expected_, obtained);
            logger.info("Finished running line #63");
            } catch (Throwable ae) {
                logger.error("Whoops, got exception on line #63:" + ae.toString());
                if(obtained instanceof Throwable) {
                    ae.addSuppressed((Throwable) obtained);
                }
                throw ae;
            }
        }

        // json.yaml line #68
        // s = b'\x66\x6f\x6f'
        logger.info("Possibly executing: byte[] s = (byte[]) (new byte[]{102, 111, 111});");
        byte[] s = (byte[]) (new byte[]{102, 111, 111});

        {
            // json.yaml line #70
            /* s */
            byte[] expected_ = s;
            /* r.binary(s) */
            logger.info("About to run line #70: r.binary(s)");
            Object obtained = runOrCatch(r.binary(s),
                                          new OptArgs()
                                          ,conn);
            try {
                assertArrayEquals(expected_, (byte[]) obtained);
            logger.info("Finished running line #70");
            } catch (Throwable ae) {
                logger.error("Whoops, got exception on line #70:" + ae.toString());
                if(obtained instanceof Throwable) {
                    ae.addSuppressed((Throwable) obtained);
                }
                throw ae;
            }
        }

        {
            // json.yaml line #73
            /* '{"$reql_type$":"BINARY","data":"Zm9v"}' */
            String expected_ = "{\"$reql_type$\":\"BINARY\",\"data\":\"Zm9v\"}";
            /* r.expr("foo").coerce_to("binary").to_json_string() */
            logger.info("About to run line #73: r.expr('foo').coerceTo('binary').toJsonString()");
            Object obtained = runOrCatch(r.expr("foo").coerceTo("binary").toJsonString(),
                                          new OptArgs()
                                          ,conn);
            try {
                assertEquals(expected_, obtained);
            logger.info("Finished running line #73");
            } catch (Throwable ae) {
                logger.error("Whoops, got exception on line #73:" + ae.toString());
                if(obtained instanceof Throwable) {
                    ae.addSuppressed((Throwable) obtained);
                }
                throw ae;
            }
        }
    }
}