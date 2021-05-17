package org.sci.finalproj.controller;

import org.sci.finalproj.model.Asset;
import org.sci.finalproj.service.AssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class WalletDetailsController {
    @Autowired
    private AssetService assetService;

    @RequestMapping(value = "/wallet-details", method = RequestMethod.GET)
    public String myWalletDetailsPage(@ModelAttribute("userEmail") String userEmail, RedirectAttributes redirectAttrs, BindingResult errors, Model model) {
        List<Asset> assetsList = assetService.getAllAssets();
        model.addAttribute("userEmail", userEmail);
        model.addAttribute("myAssetsList", assetsList);
        return "wallet-details";
    }

}
