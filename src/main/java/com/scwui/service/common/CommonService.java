package com.scwui.service.common;

import com.scwui.common.util.PropertiesUtil;
import com.scwui.common.util.RestClientUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by injeong Lee on 2017-09-27.
 */
public class CommonService {
    protected Logger logger = LoggerFactory.getLogger(super.getClass());

    @Autowired
    public RestClientUtil restClientUtil;

    @Autowired
    public PropertiesUtil propertiesUtil;
}
