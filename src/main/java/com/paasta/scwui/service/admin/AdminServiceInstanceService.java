package com.paasta.scwui.service.admin;

import com.paasta.scwui.model.ServiceInstanceList;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * Created by user on 2017-06-29.
 */
@Service
public class AdminServiceInstanceService extends CommonService {

    public ServiceInstanceList getAll(String queryString) throws Exception {

        HttpEntity<Object> entity = restClientUtil.restCommonHeaders(null);

        String url = propertiesUtil.getApi_serviceInstances();

//        ParameterizedTypeReference<ServiceInstanceList> responseType = new ParameterizedTypeReference<ServiceInstanceList>() {};

        ResponseEntity<ServiceInstanceList> response = restClientUtil.callRestApi(HttpMethod.GET, url + queryString, entity, ServiceInstanceList.class);

        logger.debug("response ::: " + response);

        ServiceInstanceList serviceInstancesList = response.getBody();

        return serviceInstancesList;
    }
}