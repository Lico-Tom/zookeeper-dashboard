package com.github.shoothzj.zdash.module;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class GetNodesResp {

    private List<String> nodes;

    public GetNodesResp() {
    }
}