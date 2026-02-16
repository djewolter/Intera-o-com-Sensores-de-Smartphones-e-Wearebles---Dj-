# ⌚ Assistente Doma - Wear OS

> **Disciplina:** DGT2816 - Interação com sensores de smartphones e wearebles
> **Projeto:** Trabalho Prático Final

## 🎯 Sobre o Projeto
Este aplicativo foi desenvolvido para a plataforma **Wear OS** como uma solução de tecnologia assistiva para a empresa fictícia "Doma". O objetivo principal é facilitar a comunicação interna e oferecer assistência a funcionários com necessidades especiais (com foco em deficiência visual), utilizando feedbacks sonoros em tempo real.

O sistema é capaz de verificar a disponibilidade de hardware de áudio no smartwatch e orientar o usuário para a conexão de fones Bluetooth, garantindo que alertas de emergência e mensagens possam ser ouvidos com segurança.

## ✨ Funcionalidades
- **Interface Otimizada:** Layout de alto contraste e navegação simplificada para telas de relógios inteligentes (Wear OS Small Round).
- **Detecção de Hardware:** Verificação em tempo real da presença de alto-falantes embutidos (`TYPE_BUILTIN_SPEAKER`).
- **Detecção de Dispositivos Externos:** Identificação de fones de ouvido Bluetooth conectados (`TYPE_BLUETOOTH_A2DP`).
- **Redirecionamento Inteligente:** Caso não haja dispositivo de áudio disponível, o app abre automaticamente as configurações de Bluetooth do relógio para facilitar o pareamento.

## 🛠️ Tecnologias Utilizadas
- **Linguagem:** Kotlin
- **Plataforma:** Android (Wear OS - API 30 / Android 11.0 R)
- **IDE:** Android Studio
- **Conceitos:** Intents, AudioManager, Gestão de Permissões (BODY_SENSORS, WAKE_LOCK).
