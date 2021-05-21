package org.sci.finalproj.controller;

import org.sci.finalproj.model.*;
import org.sci.finalproj.service.AssetService;
import org.sci.finalproj.service.CryptoCoinService;
import org.sci.finalproj.service.FiatCoinService;
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

import java.util.ArrayList;
import java.util.List;

@Controller
public class WalletDetailsController {
    @Autowired
    private AssetService assetService;
    @Autowired
    private CryptoCoinService cryptoCoinService;
    @Autowired
    private FiatCoinService fiatCoinService;
    @Autowired
    private UserService userService;

    public List<CryptoCoin> cryptoCoinList;
    public List<FiatCoin> fiatCoinList;

    @RequestMapping(value = "/wallet-details", method = RequestMethod.GET)
    public String myWalletDetailsPage(@ModelAttribute("userEmail") String userEmail, RedirectAttributes redirectAttrs, BindingResult errors, Model model) {
        User user = userService.getUserByEmail(userEmail);
        Transaction transaction = new Transaction();
        List<Asset> assetsList = assetService.getAllAssets();
        List<SuperCoin> superCoinList = new ArrayList<>();

        // List for the "Target" currency dropdown :
        cryptoCoinList = cryptoCoinService.getCryptoCoinList();
        fiatCoinList = fiatCoinService.getFiatCoinList();
        superCoinList.addAll(cryptoCoinList);
        superCoinList.addAll(fiatCoinList);
        superCoinList.forEach(coin -> System.out.println(coin.getCoinSymbol()));

        model.addAttribute("user", user);
        model.addAttribute("newTransaction", transaction);
        model.addAttribute("myAssetsList", assetsList);
        model.addAttribute("superCoinList", superCoinList);

        return "wallet-details";
    }

    @RequestMapping(value="/action", method=RequestMethod.POST, params="action=buy")
    public ModelAndView buy(@ModelAttribute("transaction") Transaction transaction, BindingResult errors, Model model) {
        Long cryptoId = transaction.getOldCurrencyId();
        CryptoCoin cryptoObject = cryptoCoinService.getCryptoByID(cryptoId);
        assetService.buyCryptoAsset(transaction.getTransactionAmount(), cryptoObject.getCryptoCoinSymbol(), transaction.getOldCurrencyId(), transaction.getUserId());
        return null;
    }

    @RequestMapping(value="/action", method=RequestMethod.POST, params="action=exchange")
    public ModelAndView exchange(@ModelAttribute("transaction") Transaction transaction, BindingResult errors, Model model) {
        return null;
    }

}
