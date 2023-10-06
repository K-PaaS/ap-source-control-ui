package com.scwui.service.admin;

import com.scwui.common.util.Common;
import com.scwui.service.common.CommonService;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;
/**
 * Created by lena on 2017-06-27.
 */
@Service
public class AdminRepositoryService extends CommonService {

    public ResponseEntity<Map> getAdminRepositories(String instanceid, Map map) {
        // 모든 Repository 조회
        // GET : /repositories/admin
        HttpEntity<Object> entity = restClientUtil.restCommonHeaders(null);
        String url = propertiesUtil.getApiRepoDashboardAdmin().replace("{instanceid}", instanceid)+"&";

        String request = Common.requestParamByMap(map);

        url+=request;
        ResponseEntity<Map> response = restClientUtil.callRestApi(HttpMethod.GET, url, entity, Map.class);
        logger.debug("response ::: "+ response);

       

        return response;
    }


}
