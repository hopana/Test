package temp;

public class CreateSQL {
	public static void main(String[] args) {
		for (int i=0; i<100; i++) {
			System.out.println("ALTER TABLE `lepos`.`t_merchant_`" + String.format("%02d", i) + " ADD COLUMN `F_business_license_name` VARCHAR(128) NULL COMMENT '营业执照名称' AFTER `F_license_end`, ADD COLUMN `F_business_license_addr` VARCHAR(128) NULL COMMENT '营业执照注册地址' AFTER `F_business_license_name`, ADD COLUMN `F_privilege_level` INT(11) DEFAULT 0 NULL COMMENT '商户特权等级:1=注册 2=基础 3=认证 4=企业' AFTER `F_bankcard_phone`; ");
		}
	}
}
