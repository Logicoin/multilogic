gconftool-2 -t string -s /desktop/gnome/url-handlers/logicoin/command "java -splash:doesnotexist.png -jar $INSTALL_PATH/multilogic-exe.jar %s"
gconftool-2 -s /desktop/gnome/url-handlers/logicoin/needs_terminal false -t bool
gconftool-2 -t bool -s /desktop/gnome/url-handlers/logicoin/enabled true