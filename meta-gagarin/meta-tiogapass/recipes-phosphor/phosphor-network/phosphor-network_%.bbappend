FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"
SRC_URI += "  \
                   file://i210-inhibit-phy-reset.service \
"

SYSTEMD_SERVICE:${PN}:append = " i210-inhibit-phy-reset.service"

do_install:append() {
  install -d ${D}${systemd_system_unitdir}
  install -m 0644 ${WORKDIR}/i210-inhibit-phy-reset.service ${D}${systemd_system_unitdir}
}
