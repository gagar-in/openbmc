FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI:append = " \
    file://GagarIn-TP.json \
    "

do_install:append() {
    install -d ${D}/usr/share/entity-manager/configurations
    install -m 0444 ${WORKDIR}/GagarIn-TP.json ${D}/usr/share/entity-manager/configurations
}