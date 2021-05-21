package org.sci.finalproj.controller;

import org.sci.finalproj.model.Asset;
import org.sci.finalproj.model.CryptoCoin;
import org.sci.finalproj.model.Transaction;
import org.sci.finalproj.model.User;
import org.sci.finalproj.service.AssetService;
import org.sci.finalproj.service.CryptoCoinService;
import org.sci.finalproj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class WalletDetailsController {
    @Autowired
    private AssetService assetService;
    @Autowired
    private CryptoCoinService cryptoCoinService;
    @Autowired
    private UserService userService;

    public List<CryptoCoin> cryptoCoinList;

    @RequestMapping(value = "/wallet-details", method = RequestMethod.GET)
    public String myWalletDetailsPage(@ModelAttribute("userEmail") String userEmail, RedirectAttributes redirectAttrs, BindingResult errors, Model model) {
        User user = userService.getUserByEmail(userEmail);
        List<Asset> assetsList = assetService.getAllAssets();

        //List for the default currency dropdown :
        cryptoCoinList = cryptoCoinService.getCryptoCoinList();
        cryptoCoinList.forEach(crypto -> System.out.println(crypto.getCryptoCoinSymbol()));

        model.addAttribute("user", user);
        model.addAttribute("myAssetsList", assetsList);
        model.addAttribute("allCryptoCoins", cryptoCoinList);

        return "wallet-details";
    }

}
