/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blogspot.mstachniuk.android.db4o.dao;

import android.content.Context;
import android.util.Log;
import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.config.EmbeddedConfiguration;
import java.io.IOException;

public class Db4oHelper {

    private static ObjectContainer oc = null;
    private Context context;

    public Db4oHelper(Context ctx) {
        context = ctx;
    }

    public ObjectContainer db() {
        try {
            if (oc == null || oc.ext().isClosed()) {
                oc = Db4oEmbedded.openFile(dbConfig(), db4oDBFullPath(context));
            }
            return oc;
        } catch (Exception ie) {
            Log.e(Db4oHelper.class.getName(), ie.toString());
            return null;
        }
    }

    private EmbeddedConfiguration dbConfig() throws IOException {
        EmbeddedConfiguration configuration = Db4oEmbedded.newConfiguration();
        return configuration;
    }

    private String db4oDBFullPath(Context ctx) {
        return ctx.getDir("data", 0) + "/" + "database.db4o";
    }

    public void close() {
        if (oc != null) {
            oc.close();
        }
    }
}
