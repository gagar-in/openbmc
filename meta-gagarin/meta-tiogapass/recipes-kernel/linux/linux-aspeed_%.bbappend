FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI += " \
         file://${MACHINE}.cfg \
         file://0001-change-flash-mem-dtsi-for-64M.patch \
"