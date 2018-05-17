package com.talentomobile.samplearch.data.storage;

import com.google.gson.Gson;
import com.talentomobile.samplearch.common.utils.Logger;

import java.io.IOException;
import java.io.InputStream;

public class StorageParserImpl implements StorageParser {

    @Override
    public <T> T parseToEntity(InputStream is, Class<T> entityClass) {
        String json;
        try {
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
            return new Gson().fromJson(json, entityClass);
        } catch (IOException ex) {
            Logger.e(ex);
        }
        return null;
    }
}
