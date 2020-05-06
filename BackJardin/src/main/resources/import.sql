INSERT INTO `roles` (`id`, `name_role`) VALUES (NULL, 'admin');
INSERT INTO `roles` (`id`, `name_role`) VALUES (NULL, 'secretary'), (NULL, 'teacher');

INSERT INTO `users` (`id`, `codigo`, `document_number`, `document_type`, `email`, `lasname`, `name`, `password`, `photo`, `status`, `user`, `role_id`) VALUES (NULL, '1234', '11233445', 'cc', 'asdasasd@asds.com', 'asdasd', 'asdasd', 'asdasd', NULL, '1', NULL, '1');
INSERT INTO `users` (`id`, `codigo`, `document_number`, `document_type`, `email`, `lasname`, `name`, `password`, `photo`, `status`, `user`, `role_id`) VALUES (NULL, '222222', '1212222', 'cc', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2');
INSERT INTO `users` (`id`, `codigo`, `document_number`, `document_type`, `email`, `lasname`, `name`, `password`, `photo`, `status`, `user`, `role_id`) VALUES (NULL, '3333333', 'qwe', 'qwe', 'qwe', 'qweq', 'eqw', 'eqwe', 'qweqw', 'eqwe', NULL, '3');

INSERT INTO `administrator` (`id`, `codigo_user_id`) VALUES (NULL, '1234');
INSERT INTO `secretary` (`id`, `codigo_user_id`) VALUES (NULL, '222222');
INSERT INTO `secretary` (`id`, `codigo_user_id`) VALUES (NULL, '3333333');