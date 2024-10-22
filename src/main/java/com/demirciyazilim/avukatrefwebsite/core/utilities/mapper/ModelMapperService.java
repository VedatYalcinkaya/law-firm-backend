package com.demirciyazilim.avukatrefwebsite.core.utilities.mapper;

import org.modelmapper.ModelMapper;

public interface ModelMapperService {
    ModelMapper forResponse();
    ModelMapper forRequest();
}
