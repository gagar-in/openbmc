FILESEXTRAPATHS:append:= "${THISDIR}/${PN}:"

EXTRA_OEMESON:append = " \
    -Dbmcweb-logging=disabled \
    -Dinsecure-tftp-update=enabled \
    -Dredfish-bmc-journal=enabled \
    "

SRC_URI += "file://0001-change-http-response-status-code-for-not-implemented.patch \
           "