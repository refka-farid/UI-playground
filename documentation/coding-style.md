### codeStyle
- This code style is for resources was inherited from the article of Jeroen Mols,that you can found [here](https://jeroenmols.com/blog/2016/03/07/resourcenaming/).
but we override some other rules/recommendations as follow:
   
##files in res/layouts
<WHAT>_<WHERE>.XML
activity_alert_dialog.xml
layout_dialog_warning.xml

##files in res/values 
colors.xml
colors_snackbar.xml
dimens.xml
dimens_alert_dialog.xml
strings.xml
strings_alert_dialog.xml
styles.xml

##files in res/drawable
<WHERE>_<DESCRIPTION>
background_dialog_constraint_layout_container.xml
icon_error.xml

##ids
<WHAT>_<WHERE>_<DESCRIPTION>
"@+id/textView_snackbarActivity_textBody"
"@+id/button_snackbarActivity_showSuccessSnackbar"

##strings in res/values/strings
<WHERE>_<DESCRIPTION>
<string name="dummy_text_title">Lorem ipsum </string>
article_detail_title: (title of ArticleDetailFragment)
<string name="all_no">No</string>

##colors in res/values/colors
<color name="color_dialog_button_action_text">@color/colorWhite</color>
<color name="color_dialog_text_body_text">@color/colorBlack2</color>

##dimens in res/values/dimens
<dimen name="padding_layout_snackbar_icon_cancel_8dp">8dp</dimen>
