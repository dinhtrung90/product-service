package com.vts.product.service.service.mapper;

import com.vts.product.service.domain.Campaign;
import com.vts.product.service.service.dto.CampaignDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * Mapper for the entity {@link Campaign} and its DTO {@link CampaignDTO}.
 */
@Mapper(componentModel = "spring", uses = {DiscountTypeMapper.class})
public interface CampaignMapper extends EntityMapper<CampaignDTO, Campaign> {

    @Mapping(source = "discountType.id", target = "discountTypeId")
    CampaignDTO toDto(Campaign campaign);

    @Mapping(source = "discountTypeId", target = "discountType")
    Campaign toEntity(CampaignDTO campaignDTO);

    default Campaign fromId(Long id) {
        if (id == null) {
            return null;
        }
        Campaign campaign = new Campaign();
        campaign.setId(id);
        return campaign;
    }
}
