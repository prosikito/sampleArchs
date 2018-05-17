package com.talentomobile.samplearch.data.storage;

import java.io.IOException;
import java.io.InputStream;

public interface StorageParser {

    <T> T parseToEntity(InputStream is, Class<T> entityClass) throws IOException;

}
