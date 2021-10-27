package org.bgerp.plugin.custom;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import ru.bgcrm.event.EventProcessor;
import ru.bgcrm.event.ParamChangedEvent;
import ru.bgcrm.plugin.Endpoint;
import ru.bgcrm.util.ParameterMap;

/**
 * BGERP Custom Demo Plugin.
 * Copy it to your own class, placed in org.bgerp.plugin package.
 *
 * @author Shamil Vakhitov
 */
public class Plugin extends ru.bgcrm.plugin.Plugin {
    public static final String ID = "custom";

    public static final String PATH_JSP_OPEN = PATH_JSP_OPEN_PLUGIN + "/" + ID;

    public Plugin() {
        super(ID);
    }

    @Override
    public boolean isEnabled(ParameterMap config, String defaultValue) {
        return true;
    }

    @Override
    protected Map<String, List<String>> loadEndpoints() {
        return Map.of(Endpoint.JS, List.of(Endpoint.getPathPluginJS(ID)));
    }

    @Override
    public void init(Connection con) throws Exception {
        super.init(con);

        EventProcessor.subscribe((e, conSet) -> {
            //log.
        }, ParamChangedEvent.class);
    }
}