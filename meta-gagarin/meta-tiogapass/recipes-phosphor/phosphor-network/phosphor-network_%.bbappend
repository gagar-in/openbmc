FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"
SRC_URI += "  \
                   file://i210-inhibit-phy-reset.service \
                   file://config.json \
"

SYSTEMD_SERVICE:${PN}:append = " i210-inhibit-phy-reset.service"
FILES:${PN} += "${datadir}/network"

do_install:append() {
  install -d ${D}${systemd_system_unitdir}
  install -m 0644 ${WORKDIR}/i210-inhibit-phy-reset.service ${D}${systemd_system_unitdir}
  install -d ${D}${datadir}/network
  install -m 0644 ${WORKDIR}/config.json ${D}${datadir}/network/
}
