package naakcii.by.api.action.service;

import naakcii.by.api.chain.service.modelDTO.ChainDTO;

import java.util.List;

public interface ActionService {
    public List<Integer> getDiscounAndAllActionsByChain(ChainDTO chainDTO);
}
