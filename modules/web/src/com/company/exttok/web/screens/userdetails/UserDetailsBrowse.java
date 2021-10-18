package com.company.exttok.web.screens.userdetails;

import com.haulmont.cuba.gui.screen.*;
import com.company.exttok.entity.UserDetails;

@UiController("exttok_UserDetails.browse")
@UiDescriptor("user-details-browse.xml")
@LookupComponent("table")
@LoadDataBeforeShow
public class UserDetailsBrowse extends MasterDetailScreen<UserDetails> {
}