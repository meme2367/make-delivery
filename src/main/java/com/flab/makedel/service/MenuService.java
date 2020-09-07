package com.flab.makedel.service;

import com.flab.makedel.dto.MenuDTO;
import com.flab.makedel.mapper.MenuMapper;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MenuService {

    private final MenuMapper menuMapper;

    public void insertMenu(MenuDTO menu) {
        menuMapper.insertMenu(menu);
    }

    public MenuDTO setStoreId(MenuDTO menu, Long storeId) {
        MenuDTO newMenu = MenuDTO.builder()
            .name(menu.getName())
            .price(menu.getPrice())
            .photo(menu.getPhoto())
            .description(menu.getDescription())
            .menuGroupId(menu.getMenuGroupId())
            .storeId(storeId)
            .build();
        return newMenu;
    }

    public void deleteMenu(Long menuId) {
        menuMapper.deleteMenu(menuId);
    }

    public List<MenuDTO> loadStoreMenu(Long storeId) {
        return menuMapper.selectStoreMenu(storeId);
    }

}
