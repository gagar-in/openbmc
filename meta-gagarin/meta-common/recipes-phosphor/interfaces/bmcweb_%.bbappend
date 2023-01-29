FILESEXTRAPATHS:append:= "${THISDIR}/${PN}:"

EXTRA_OEMESON:append = " \    
    -Dbmcweb-logging=disabled \
    -Dinsecure-tftp-update=enabled \
    -Dredfish-bmc-journal=enabled \
    "
