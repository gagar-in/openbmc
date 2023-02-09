FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"


# Ignore patches for now since they refer to old version above
SRC_URI += "file://phosphor-ipmi-host.service \           
            "
EXTRA_OECONF:append = " --disable-i2c-whitelist-check"
EXTRA_OECONF:append = " --disable-ipmi-whitelist"

do_install:append(){
  install -d ${D}${includedir}/phosphor-ipmi-host
  install -m 0644 -D ${S}/sensorhandler.hpp ${D}${includedir}/phosphor-ipmi-host
  install -m 0644 -D ${S}/selutility.hpp ${D}${includedir}/phosphor-ipmi-host
}
