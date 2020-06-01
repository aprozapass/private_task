package com.converter;

import com.model.csv.ClientCsvBean;
import com.model.db.ClientEntity;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
final public class ClientConverter implements Converter<ClientCsvBean, ClientEntity> {
    @Override
    public ClientEntity convert(ClientCsvBean clientCsvBean) {
        return new ClientEntity(
                clientCsvBean.getName(),
                clientCsvBean.getEmail(),
                clientCsvBean.getPhone()
        );
    }
    
    public List<ClientEntity> convertAll(List<ClientCsvBean> clientCsvBeans) {
        List<ClientEntity> clientEntities = new ArrayList<>(clientCsvBeans.size());
        for (ClientCsvBean clientCsvBean : clientCsvBeans) {
            clientEntities.add(convert(clientCsvBean));
        }
        return clientEntities;
    }
}
