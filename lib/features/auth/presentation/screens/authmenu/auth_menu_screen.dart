import 'package:auto_route/auto_route.dart';
import 'package:flutter/material.dart';
import 'package:invoicer_web/navigation/app_router.gr.dart';

import '../../components/auth_container.dart';
import 'components/auth_menu_right_section.dart';

@RoutePage()
class AuthMenuScreen extends StatelessWidget {
  const AuthMenuScreen({super.key});

  @override
  Widget build(BuildContext context) {
    final navigator = AutoRouter.of(context);

    return AuthContainer(
      leftSection: Column(
        crossAxisAlignment: CrossAxisAlignment.center,
        mainAxisAlignment: MainAxisAlignment.center,
        children: [
          Text(
            "Welcome to Invoicer",
            style: TextStyle(
              fontSize: 64,
              fontWeight: FontWeight.w700,
              color: Theme.of(context).colorScheme.surface,
            ),
            textAlign: TextAlign.center,
          ),
        ],
      ),
      rightSection: AuthMenuRightSection(
        onSignInTap: () {
          navigator.push(SignInRoute());
        },
        onSignUpTap: () {},
      ),
    );
  }
}
