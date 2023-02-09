FILESEXTRAPATHS:append:= "${THISDIR}/${PN}:"

EXTRA_OEMESON:append = " \
    -Dbmcweb-logging=disabled \
    -Dinsecure-tftp-update=enabled \
    -Dredfish-dbus-log=enabled \
    "

SRC_URI += "file://0001-change-http-response-status-code-for-not-implemented.patch \
            file://0002-change-http-response-status-code-for-property-errors.patch \
           "

