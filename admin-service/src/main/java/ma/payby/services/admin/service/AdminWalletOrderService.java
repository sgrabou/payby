package ma.payby.services.admin.service;

import ma.payby.common.dto.OrderDTO;
import ma.payby.common.exception.BusinessException;
import ma.payby.common.utils.CommonUtils;
import ma.payby.services.admin.client.AdminMerchandClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminWalletOrderService {
    @Autowired
    AdminMerchandClient adminMerchandClient;

    public OrderDTO getOrder(String reference) throws BusinessException {
        OrderDTO orderDTO =adminMerchandClient.findByReference(reference);
        if(orderDTO==null)
            throw new BusinessException("M00002", CommonUtils.ERROR_BUSINESS.get("M00002"));
        return orderDTO;
    }

    public OrderDTO getOrderById(Long id) throws BusinessException {
        OrderDTO orderDTO = adminMerchandClient.findById(id);
        if(orderDTO == null)
            throw new BusinessException("M00002", CommonUtils.ERROR_BUSINESS.get("M00002"));
        return orderDTO;
    }

    public OrderDTO getOrderByReference(String reference) throws BusinessException {
        OrderDTO orderDTO = adminMerchandClient.findByReference(reference);
        if(orderDTO == null)
            throw new BusinessException("M00002", CommonUtils.ERROR_BUSINESS.get("M00002"));

        return orderDTO;
    }

    public List<OrderDTO> getAllOrder() throws BusinessException {
        return adminMerchandClient.findAll();
    }
}
