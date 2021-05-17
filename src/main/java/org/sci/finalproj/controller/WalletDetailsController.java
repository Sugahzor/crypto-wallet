package org.sci.finalproj.controller;

import org.sci.finalproj.model.Asset;
import org.sci.finalproj.service.AssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class WalletDetailsController {
    @Autowired
    private AssetService assetService;

//    @RequestMapping("/wallet-details")
//    public String myWalletDetailsPage(Model model, @RequestParam(value="name", required=false) String name) {
//        System.out.println("why isn't it navigating");
//
//        List<Asset> assetsList = assetService.getAllAssets();
//        model.addAttribute("name", name);
//        model.addAttribute("myAssetsList", assetsList);
//        return "wallet-details";
//    }

}
